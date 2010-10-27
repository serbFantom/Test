package com.serb.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sbezugliy
 * Date: 01.03.2010
 */
/**
* ������������� ��������� ������, ����������� � �������������� ����� ��������� ��������������
* ��� �����������.
*
* @author Pavel Samolisov
*/
public class CollectionsUtils {

  public static <E> List<E> filter(List<E> data, IPredicate<E> predicate) {
    List<E> result = new ArrayList<E>();
    for (E e : data)
      if (predicate.apply(e))
        result.add(e);

    return result;
  }

  public static <E> List<E> trim(List<E> data) {
    return filter(data, new IPredicate<E>() {
      public boolean apply(E input) {
        return input != null;
      }
    });
  }

  public static <F, T> List<T> transform(List<F> data, IFunction<F, T> function) {
    List<T> result = new ArrayList<T>();
    for (F elem : data)
      result.add(function.apply(elem));
    return result;
  }
}
