package com.serb.tstinit;

/**
 * User: SBezugliy
 * Date: 09.02.2009 12:03:54
 */
class Raptor extends Bird {
    static {
        System.out.print("r1 ");
    }

    public Raptor() {
        System.out.print("r2 ");
    }

    {
        System.out.print("r3 ");
    }

    static {
        System.out.print("r4 ");
    }
}
