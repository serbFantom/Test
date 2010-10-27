package com.serb.common_tutorial;

//import com.serb.common_tutorial.FirstTestSerb;

/**
 * User: sbezugliy
 * Date: 18.08.2008 16:41:44
 */
public class SecondTestSerb {

    public void secondTest() {
        System.out.println("*******************SecondTestSerb.secondTest()");
        FirstTestSerb firstTest= new FirstTestSerb();
        firstTest.firstTest();
    }

    public static void main(String[] args) {
        SecondTestSerb secondTest= new SecondTestSerb();
        secondTest.secondTest();
    }
}
