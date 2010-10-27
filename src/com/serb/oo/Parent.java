package com.serb.oo;

/**
 * Created by SBezugliy
 * Date: 21.10.2009
 */
class Parent {
    private int x=2;
    public void printX() {
        System.out.println("x= "+x);
    }
    public void outMe() {
        System.out.println("Parent");
    }

    public boolean equals(Object obj) {
        return true;
    }


}
