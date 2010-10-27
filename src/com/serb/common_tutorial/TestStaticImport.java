package com.serb.common_tutorial;

/**
 * Created by SBezugliy
 * Date: 19.10.2009
 */
import static java.lang.System.out;
import static java.lang.Integer.MAX_VALUE;

public class TestStaticImport {

    public static void main (String[] args) {
        out.println(MAX_VALUE);
        int i = 4;
      int ia[][][] = new int[i][i = 3][i];
      System.out.println( ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
    }
}
