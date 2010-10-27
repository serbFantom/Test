package com.serb.tstinit;

/**
 * User: SBezugliy
 * Date: 09.02.2009 12:03:43
 */
class Bird {
    static {
        System.out.print("b1 ");
    }

    public Bird() {
        System.out.print("b2 ");
    }
}
