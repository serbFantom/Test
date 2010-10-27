package com.serb.common_tutorial;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 01.08.2008
 * Time: 13:36:40
 */
public class Wolf extends Animal {
    private String someField;
    public Wolf() {
        setName("Wolf");
        setAge("3");
        printClassName();
    }

    public void someMethod() {
        int x=1;
        x=3;
        System.out.println("x= "+x);
    }
}
