package com.serb.operators;

/**
 * User: SBezugliy
 * Date: 09.02.2009 14:04:32
 */
public class OperatorsTest extends Tests implements OperatorsInterface {

    static int players = 0;

    static final String str = null;

    public void printInfo() {
        System.out.println("OperatorsTest.printInfo()");
    }

    public void compareNumbers() {
        System.err.println("Not implemented yet!");
    }


    static enum Color {
        RED, BLUE
    }

    public static void main(String[] args) {
        System.out.println("-------------------OperatorsTest-------------------");
        int y = 0, x = 2;
        //y = y - 6;
        //x = x + 2 * 5;
        //Now, with compound operators:
        double g=1e+3;
        System.out.println("g= "+g);
        y -= 6;
        x *= 2 + 5;

        OperatorsTest opt = new OperatorsTest();
        opt.printInfo();

        System.out.println("x= " + x);
        System.out.println("y=" + y);

        comparePrimitives();

        //instanceOfTest();

        //remainderTest();

        //concatTest();

        testIncrementDecrement();

        conditionalOperatorTest();

        testBitwiseOperators();

        orOperatorTest();

        xorOperatorTest();

    }

    static class Dog {

    }

    static class Cat {

    }

    /**
     * Test inmstanceof operator
     */
    static void instanceOfTest() {
        if (String.class instanceof Object) {
            System.out.println("String class is instance of Object");
        }

        OperatorsTest opTest = new OperatorsTest();
        if (opTest instanceof OperatorsInterface) {
            System.out.println("OperatorsTest is implementing OperatorsInterface");
        }

        if (null instanceof OperatorsInterface) {
            System.out.println("null is implementing OperatorsInterface");
        }
        /*Cat cat= new Cat();
        if (cat instanceof Dog) {
            System.out.println("null is implementing OperatorsInterface");
        }*/
        A a = new A();
        if (a instanceof B) {
            System.out.println("a is implementing OperatorsInterface");
        }

        int[] nums = new int[3];
        if (nums instanceof Object) {
            System.out.println("nums is a Object");
        } // result is true

        if (nums instanceof int[]) {
            System.out.println("nums is a int[]");
        }
    }

    static void comparePrimitives() {
        System.out.println("char 'a' == 'a'? " + ('a' == 'a'));
        System.out.println("char 'a' == 'b'? " + ('a' == 'b'));
        System.out.println("5 != 6? " + (5 != 6));
        System.out.println("5.0 == 5L? " + (5.0 == 5L));
        System.out.println("true == false? " + (true == false));

        System.out.println("\"string1\"=\"string1\"? " + ("string1" == "string1"));

        System.out.println("\"string1\"!=\"string1\"? " + ("string1" != "string1"));

        String s1 = "string1";
        String s2 = "string2";
        //s2=s1;
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 != s2? " + (s1 != s2));
    }

    /**
     * Remainder (%) operator test
     */
    static void remainderTest() {
        int x = 4;
        double y = x % 3.5;
        System.out.println("The result of 100 % 25 is the "
                + "remainder of 100 divided by 25. The remainder is " + y);

    }

    static void concatTest() {
        System.out.println("-------------------concatTest------------------------------------");
        String a = "String";
        int b = 3;
        int c = 7;
        System.out.println(a + b + c);

        String s = "123";
        s += "45";
        s += 67;
        System.out.println(s);
    }

    static void testIncrementDecrement() {
        System.out.println("-------------------testIncrementDecrement------------------------------------");
        System.out.println("players online: " + players++);
        System.out.println("The value of players is "
                + players);
        System.out.println("The value of players is now "
                + ++players);

        int x = 2;
        int y = 3;
        if ((y == x++) | (x < ++y)) {
            System.out.println("x = " + x + " y = " + y);
        }
    }

    static void conditionalOperatorTest() {
        System.out.println("-------------------conditionalOperatorTest------------------------------------");
        int numOfPets = 5;
        String status = (numOfPets < 4) ? "Pet limit not exceeded" : "too many pets";
        System.out.println("This pet status is " + status);

        //

        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";

        String strTmp = str3;

        String strongStr = strTmp.equals(str1) ? "Equals str1" : strTmp.equals(str2) ?
                "Equals str2" : strTmp.equals(str3) ? "Equals str3" : "Not equals str1 str2 or str3";

        System.out.println(" " + strongStr);
    }

    static void testBitwiseOperators() {
        System.out.println("-------------------------testBitwiseOperators------------------------------");
        byte b1 = 6 & 10;
        byte b2 = 7 | 9;
        byte b3 = 5 ^ 4;
        System.out.println(b1 + " " + b2 + " " + b3);
    }

    static void orOperatorTest() {
        System.out.println("-------------------------orOperatorTest------------------------------");
        if ((isItSmall(3)) || (isItSmall(7))) {
            System.out.println("Result is true");
        }
        if ((isItSmall(6)) || (isItSmall(9))) {
            System.out.println("Result is true");
        }
    }

    private static boolean isItSmall(int i) {
        if (i < 5) {
            System.out.println("i < 5");
            return true;
        } else {
            System.out.println("i >= 5");
            return false;
        }
    }

    static void xorOperatorTest() {
        System.out.println("-------------------------xorOperatorTest------------------------------");
        if (false^false) {
            System.out.println("(2<3)^(4<6)");
        }
        Integer x = 0;
        Integer y = 0;
        for(Short z = 0; z < 5; z++)
        if((++x > 2) || (++y > 2))
        x++;
        System.out.println(x + " " + y);
                               
    }

}
