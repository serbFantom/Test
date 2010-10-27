package com.serb.oo;

import java.io.FileNotFoundException;

/**
 * Created by SBezugliy
 * Date: 14.10.2009
 */
public class I12Impl implements I1,I2 {
    int i=getInt();
    int k=20;

    public int getInt () {        
        return k+1;
    }
    public void m1() throws FileNotFoundException {
        //
    }

    public final void doSomethingFinalVersion() {
        System.out.println("I12Impl doSomethingFinalVersion");
    }
    
    public void doSomething() throws Exception {
        System.out.println("I12Impl doSomething");
    }
}
