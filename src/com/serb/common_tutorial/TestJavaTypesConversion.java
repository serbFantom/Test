package com.serb.common_tutorial;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 25.07.2008
 * Time: 17:06:33
 */
public class TestJavaTypesConversion {
    public static void testLongConversion() {
        System.out.println("*************testLongConversion()");
        long a=3;
        a = 5+'A'+a;
        System.out.println("a= "+a);
        System.out.println("Math.round(a/2F)= "+Math.round(a/2F));
    }
    public static void printChar(char chr) {
        System.out.println("*************printChar()");
        System.out.println("char= "+chr);
    }

    /**
     * Prints infinity's in differrent  types
     */
    static public void infinityConversion() {
        System.out.println("*************infinityConversion()");
        float fmin = Float.NEGATIVE_INFINITY;
        float fmax = Float.POSITIVE_INFINITY;
        System.out.println("long: " + (long)fmin + ".." + (long)fmax);
        System.out.println("int: " + (int)fmin + ".." +(int)fmax);
        System.out.println("short: " + (short)fmin + ".." +(short)fmax);
        System.out.println("char: " + (int)(char)fmin + ".." +(int)(char)fmax);
        System.out.println("byte: " + (byte)fmin + ".." +(byte)fmax);
    }

    static public void testReferencesTypesConversion() {
         Wolf w = new Wolf();
         Animal a = (Animal)w;
         Rabbit r = (Rabbit)a;
    }

    /*public static void testReferncesTypesConversion() {
        Parent p=new Child(); 
    }*/

    //
    class Parent {
       int x;
    }

    public Child createChildInstance() {
        return new Child();       
    }
    //
    class Child extends Parent {
       int y;
    }

    class Child2 extends Parent {
       int z;
    }
}
