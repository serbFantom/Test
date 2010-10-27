package com.serb.threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class NameList {
    private List names = Collections.synchronizedList(
            new LinkedList());

    public void add(String name) {
        names.add(name);
    }

    public String removeFirst() {
        if (names.size() > 0)
            return (String) names.remove(0);
        else
            return null;
    }
}
