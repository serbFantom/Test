package com.serb.gc;

/**
 * User: SBezugliy
 * Date: 06.02.2009 10:50:37
 */
import java.util.Date;

public class GarbageFactory {

    public static void main(String [] args) {
        Date d = getDate();
        doComplicatedStuff();
        System.out.println("d = " + d);
    }

    public static Date getDate() {
        Date d2 = new Date();
        StringBuffer now = new StringBuffer(d2.toString());
        System.out.println(now);
        return d2;
    }

    static void doComplicatedStuff() {
        
    }
}