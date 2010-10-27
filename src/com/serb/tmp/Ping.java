package com.serb.tmp;

/**
 * Created by SBezugliy
 * Date: 21.10.2009
 */
public class Ping extends Utils {
    public static void main(String[] args) throws Exception {
        Utils u = new Ping();
        System.out.print(u.getInt(args[0]));
    }

    int getInt(String arg) throws Exception {
        return Integer.parseInt(arg);
    }
}
