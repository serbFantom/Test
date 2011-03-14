package com.serb.test_patterns;

/**
 * User: S.Bezuglyi
 * Date: Dec 15, 2010
 */
public enum SingletonTst2 {
   INSTANCE;
    protected int singleX=120;

    public void printSomething()
    {
        System.out.println("Print something instance.hashCode(): "+this.hashCode());
    }
}
