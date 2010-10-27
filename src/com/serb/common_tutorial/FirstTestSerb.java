package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 18.08.2008 16:39:40
 */
public class FirstTestSerb {    
    public void firstTest() {

        System.out.println("****************FirstTestSerb.firstTest()");
        System.out.println("Thread.currentThread().getClass().getName()= "+Thread.currentThread().getClass().getName());
        //getStackTrace()
        //Thread.currentThread().getStackTrace()[1].getClassName();
    }
}
