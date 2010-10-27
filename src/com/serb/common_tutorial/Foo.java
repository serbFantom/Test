package com.serb.common_tutorial;

/**
 * User: S.Bezuglyi
 * Date: Oct 11, 2010
 * Time: 2:16:36 PM
 */
public class Foo {

    private static Foo instance = new Foo();
    private static final int DELTA = 6;
    private static int BASE = 7;
    private int x;

    private Foo() {
        x = BASE + DELTA;
    }
    
    public static void main(String... argv) {

        System.out.println("Foo.instance.x= "+Foo.instance.x);
        Foo foo=new Foo();
        System.out.println("Foo.x= "+foo.x);
    }

}
