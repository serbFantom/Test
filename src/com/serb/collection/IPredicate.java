package com.serb.collection;

/**
 * User: sbezugliy
 * Date: 01.03.2010
 */
public interface IPredicate<T> {
  public boolean apply(T input);
}
