package com.serb.common_tutorial.vehicles_example;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * User: SBezugliy
 * Date: 29.08.2008 15:20:10
 */
public abstract class Car extends Vehicle {
    
    protected String type;

    private static String someString="someString";

    public void goUpHill() {
        System.out.println("goUpHill() is implemented");
    }
    
    public Car() {
        this(getSomeString());        
        System.out.println("Car constructor invoked");
        type="com.serb.common_tutorial.vehicles_example.Car";
    }

    public Car(String type) {
        //this();
        this.type=type;
        System.out.println("Car(String type) constructor invoked");
    }


    public void doCarThings() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method meth=this.getClass().getMethod("doCarThings");
        System.out.println("abstract class Car method is:  "+meth.getName());    
    }

    public void setPropertiesAsConcreteAuto(Car car) {
        System.out.println("Car.setPropertiesAsConcreteAuto(Car)");
        //
    }

    public void doStuff(int y, String s) {
        System.out.println("Car.doStuff(int y, String s)");    
    }

    public void go() {
        System.out.println("void Car.go()");
    }

    Car go (int i) {
        return new Dodge();
    }

    private static String getSomeString() {
        return someString;
    }

    //abstract void someCarMethod();
    
}
