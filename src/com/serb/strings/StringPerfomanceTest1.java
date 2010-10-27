package com.serb.strings;

/**
 * This class shows the use of intern() method to improve performance
 *
 * User: S.Bezuglyi
 * Date: Aug 25, 2010
 */
public class StringPerfomanceTest1 {

    public static void main(String[] args) {

        // create String references like s1,s2,s3...so on..
        String variables[] = new String[50000];
        for (int i = 0; i < variables.length; i++) {

            variables[i] = "s" + i;

        }

        // create String literals
        long startTime0 = System.currentTimeMillis();

        for (int i = 0; i < variables.length; i++) {

            variables[i] = "hello";

        }

        long endTime0 = System.currentTimeMillis();

        System.out.println("Time taken for creation of String literals : "

                + (endTime0 - startTime0) + " milli seconds");

        // create String objects using 'new' keyword

        long startTime1 = System.currentTimeMillis();


        for (int i = 0; i < variables.length; i++) {

            variables[i] = new String("hello");

        }

        long endTime1 = System.currentTimeMillis();

        System.out.println("Time taken for creation of String objects with 'new' key word : "

                + (endTime1 - startTime1) + " milli seconds");

        // intern String objects with intern() method

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < variables.length; i++) {
            variables[i] = new String("hello");
            variables[i] = variables[i].intern();
        }

        long endTime2 = System.currentTimeMillis();

        System.out.println("Time taken for creation of String objects with intern(): "

                + (endTime2 - startTime2) + " milli seconds");

    }
}
