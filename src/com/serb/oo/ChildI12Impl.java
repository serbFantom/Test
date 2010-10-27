package com.serb.oo;

/**
 * Created by SBezugliy
 * Date: 14.10.2009
 */
public class ChildI12Impl extends I12Impl implements I1, I2 {

    public final void doSomethingFinalVersion(String s) {
        System.out.println("s= " + s);
    }

    public void doSomething() {
        System.out.println("ChildI12Impl doSomething");
    }
}
