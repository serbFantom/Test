package com.serb.flow_control;

/**
 * User: sbezugliy
 * Date: 11.02.2009 16:52:12
 */
public class CyclesTest {

    public static void main (String[] args) {
        whileCycleTest();
        doWhileCycleTest();
        basicForCycleTest();
        enhancedForCycleTest();
    }

    static void whileCycleTest() {
        System.out.println("*********************************whileCycleTest*********************************");
        int x=0;
        while (x<=2) {
            System.out.println("In while x= "+x);
            x++;
        }
        System.out.println("After while x= "+x);
    }


    static void doWhileCycleTest() {
        System.out.println("*********************************doWhileCycleTest*********************************");
        int x=0;

        do {
            System.out.println("In do while x= "+x);
            x++;
        } while (x<=2);

        System.out.println("After do while x= "+x);
    }

    static void basicForCycleTest() {
        System.out.println("*********************************basicForCycleTest*********************************");
        int x=0;
        int length=5;

        for (x=0;x<=5;x++) {
            System.out.println("In basic for x= "+x);           
        }

        System.out.println("After basic for x= "+x);

        System.out.println("--------------------------------------");
        for (;x<10;) {
            System.out.println("In basic for x= "+x);
            x++;
        }

        System.out.println("--------------------------------------");
        for (int i = 0,j = 0; (i<3) && (j<3); i++, j++) {
            System.out.println("i is " + i + " j is " +j);
        }

        System.out.println("--------------------------------------");
        int b = 3;
        for (int a = 1; b != 1; System.out.println("iterate")) {
            b = b - a;
        }

    }


    static void enhancedForCycleTest() {
        System.out.println("*********************************enhancedForCycleTest*********************************");
        int x=0;

        //System.out.println("In basic for x= "+x);

        //System.out.println("After basic for x= "+x);

        int [] a = {1,2,3,4};

        for (int n:a) {
            System.out.println("n= "+n);
        }

    }


}
