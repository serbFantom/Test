package com.serb.strings;

/**
 * This class shows the time taken for creation of String literals and String objects.
 * 
 * User: S.Bezuglyi
 * Date: Aug 25, 2010
 */
public class StringPerfomanceTest2 {

    private static final int ITERATION_COUNT=2000000;

    public static void main(String[] args) {
        // create String literals
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for creation of String literals : "
                + (endTime - startTime) + " milli seconds");
        // create String objects using 'new' keyword
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < ITERATION_COUNT; i++) {
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken for creation of String objects : "
                + (endTime1 - startTime1) + " milli seconds");

    }

}
