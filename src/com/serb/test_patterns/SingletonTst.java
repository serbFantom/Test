package com.serb.test_patterns;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 13.03.2008
 * Time: 15:40:29
 */
public class SingletonTst {
    private static SingletonTst _singletonTest=null;
    protected int x=200;

    private SingletonTst() {
    }
    public static SingletonTst getInstance() {
        if (_singletonTest==null)
            return new SingletonTst();
        return _singletonTest;    
    }

    public static void main(String [] args) {
        System.out.println("Singleton Test");
    }
}
