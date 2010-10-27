package com.serb.common_tutorial.vehicles_example;

import java.lang.reflect.InvocationTargetException;
import java.io.IOException;

/**
 * User: SBezugliy
 * Date: 29.08.2008 15:23:44
 */
public class Bmw extends Car {
    
    protected String type="com.serb.common_tutorial.vehicles_example.Bmw";

    private int orderNo;

    public void goUpHill() {
        super.goUpHill();
        System.out.println("Bmw goUpHill()");
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public Bmw() {
        System.out.println("Bmw constructor invoked");
        type="com.serb.common_tutorial.vehicles_example.Bmw";
        this.orderNo=(int)(Math.random()*1000);
    }

    public Bmw(String type) {
        super(type);        
        System.out.println("Bmw(String type) constructor invoked");        
        this.type=type;
        this.orderNo=(int)(Math.random()*1000);
    }

    public Bmw(String type, int orderNo) {
        System.out.println("Bmw(String type, int orderNo) constructor invoked");
        this.type=type;
        this.orderNo=orderNo;
    }

    public static String getTypeStatic() {
        return "com.serb.common_tutorial.vehicles_example.Bmw";
    }

    public static void main(String args[]) {
        Bmw bmwClazz=new Bmw();
        try {
            bmwClazz.doCarThings();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
            //throw new NoSuchMethodException(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getType() {
        return type;
    }

    /*public String go() {

    }*/


    public void doStuff(int y, long s) throws IOException {

    }


    public void move() {
    }

    public void moveB() {
    }

    public void moveA() {
    }
}
