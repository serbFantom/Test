package com.serb.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * User: SBezugliy
 * Date: 08.12.2009
 */
public class TestWildcards {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        Bar bar = new Bar();
        bar.doInsert(myList);
        if (false) ;
        else ;
    }
}

class Bar {
    void doInsert(List<?> list) {
        //list.add(new Dog());add does not work
    }
}
