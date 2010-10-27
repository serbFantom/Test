package com.serb.collection;

/**
 * User: sbezugliy
 * Date: 01.03.2010
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
* ������������� �������������� ��� �����������, ����������� � �������������� �����.
* ��������� ������� ������ ����������. ��������� ������� ��������� ��������������.
*
* @author Pavel Samolisov
* @param <E>
*/
public class LazyCollections<E> {

  private List<?> data;

  private List<IPredicate<?>> predicates = new ArrayList<IPredicate<?>>();

  private PredicatesForFunction predicatesForFunction = new PredicatesForFunction();

  public LazyCollections(List<E> data) {
    this.data = data;
  }

  private LazyCollections(List<?> data, PredicatesForFunction predicatesForFunctions) {
    this.data = data;
    this.predicatesForFunction = predicatesForFunctions;
  }

  public LazyCollections<E> filter(IPredicate<E> predicate) {
    predicates.add(predicate);
    return this;
  }

  public <T> LazyCollections<T> transform(IFunction<E, T> function) {
    predicatesForFunction.put(function, new ArrayList<IPredicate<?>>(predicates));
    predicates.clear();
    return new LazyCollections<T>(data, predicatesForFunction);
  }

  public LazyCollections<E> trim() {
    return filter(new IPredicate<E>() {
      public boolean apply(E input) {
        return input != null;
      }
    });
  }

  public List<E> toList() {
    List<E> result = new ArrayList<E>();
    for (Object element : data)
    {
      boolean isContained = true;
      for (Entry<IFunction<?, ?>, List<IPredicate<?>>> entry : predicatesForFunction.entrySet()) {
        List<IPredicate<?>> predicates = entry.getValue();
        for (IPredicate<?> predicate : predicates) {
          isContained &= ((IPredicate<Object>) predicate).apply(element);
          if (!isContained)
            break; // �� ���� ��������� ������ - � ��� ��� ����
        }

        if (!isContained)
          break; // �������� �� ����� � �������������� ������ - ��� ������ ���-�� ������

        element = ((IFunction<Object, Object>) entry.getKey()).apply(element);
      }

      if (!isContained)
        continue;

      // �������� �� ������������ ����������, ����������� ����� ���� �������������
      for (IPredicate<?> pred : predicates)
        isContained &= ((IPredicate<Object>) pred).apply(element);

      if (isContained)
        result.add((E) element);
    }

    return result;
  }

  private static class PredicatesForFunction extends HashMap<IFunction<?, ?>, List<IPredicate<?>>> {
    private static final long serialVersionUID = -9105118625526879527L;
  }
}
