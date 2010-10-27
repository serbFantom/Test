package com.serb.test_patterns;

import java.util.Arrays;

/**
 * User: SBezugliy
 * Date: 29.08.2008 14:55:16
 */
public class ToDelMyClass2 {
    protected int protectX=100;
    //private int x=-100;

    public final void printSomething() {
        System.out.println("Super class ToDelMyClass2.printSomething() final method");
    }
    
    public void printStr(String... str) {
        //System.out.println(new StringBuilder().append("ToDelMyClass2.printStr= ").append(str).toString());
        System.out.println("ToDelMyClass2.printStr= "+ Arrays.toString(str));
    }
    
    public void printInt(int... x) {
         System.out.println("ToDelMyClass2.printInt= "+ Arrays.toString(x));//
    }

    public void printInt2(int x, int... y) {
         System.out.println("ToDelMyClass2.printInt2= "+ Arrays.toString(y));//
    }


}
