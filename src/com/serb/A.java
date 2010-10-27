package com.serb;


/**
 * User: SBezugliy
 * Date: 21.04.2010
 */
public class A {
    public A() {
        
    }
    public A(String title) {

    }
    public A(String title,int id) {

    }
    public static void main(String[] args) {
        //B b=new A();
         A a1=new B();
        String str="test";
         a1.modifyString(str);
        System.out.println(str);
         A a2=new C();
         //C c1=new A();
        Object o=new A(null);
        
    }

    private void modifyString(String str) {
        str=str.replace('t','f');
        str="Another Value";
        
    }

    //: GopherVector.java
// A type-conscious Vector
//import java.util.*;






}
