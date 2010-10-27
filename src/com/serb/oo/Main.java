package com.serb.oo;

/**
 * Created by SBezugliy
 * Date: 14.10.2009
 */
public class Main {

    public String toString() {
        return "4" + "3";
    }
    enum State {
        START,STOP,UNKNOWN
    }
    public static void main(String[] args) {
        /*A o1 = new C();
        C o2 = (C) o1;
        System.out.println(o1.m1());
        System.out.println(o2.i);*/
        //I12Impl test=new ChildI12Impl();
        //test.doSomething();


        /*State st=State.UNKNOWN;
        switch (st) {
            case STOP:
                System.out.println("STOP");
                break;
            case START:
                System.out.println("START");
                break;
            default:
                System.out.println("UNKNOWN!!!");
        }*/
        /*try {
            String[] strArr ={"1","2"};
            System.out.print(strArr[5]);           
        } catch (Throwable th) {
            System.err.println("Exception ex"+th);
        }*/
        //System.out.println(StringUtils.capitalize("some string not in capital ksdhj dfjkl iewuriouwe weurfuew"));

        String strOrig="some string not in capital ksdhj dfjkl iewuriouwe weurfuew";
        String strRes = String.format(strOrig.replaceAll("\\b(\\S)", "%S"),
                (Object[])strOrig.replaceAll("\\b(\\S)\\S*", "$1").split("\\s+"));

        System.out.println("strOrig= "+strOrig);
        System.out.println("strRes= "+strRes);
    }
}

class A {
    int i = 10;

    int m1() {
        return i;
    }
}

class B extends A {
    int i = 20;

    int m1() {
        return i;
    }
}

class C extends B {
    int i = 30;

    int m1() {
        return i;
    }
}
