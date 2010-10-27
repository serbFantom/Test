package com.serb.common_tutorial.vehicles_example;

/**
 * User: SBezugliy
 * Date: 29.08.2008 15:18:15
 */
public abstract class Vehicle implements A, B {

    protected String type="com.serb.common_tutorial.vehicles_example.Vehicle";

    protected abstract void goUpHill();
    //abstract void doStuff();
    private String getType() { // Non-abstract method
        return type;
    }

    protected static String getTypeStatic() {
        return "com.serb.common_tutorial.vehicles_example.Vehicle";
    }    

    public static void main (String[] args) {

        /*Polymorfism test */
        /*Vehicle v = new Bmw();
        System.out.println("v.getType()= "+v.getType());
        System.out.println("v.type= "+v.type);
        System.out.println("((Bmw)v).type= "+((Bmw)v).type);
        System.out.println("((Bmw)v).getType()= "+((Bmw)v).getType());
        //static methods
        System.out.println("v.getTypeStatic()= "+v.getTypeStatic());
        System.out.println("((Bmw)v).getTypeStatic()= "+((Bmw)v).getTypeStatic());
        //simply for fun
        //System.out.println("((Dodge)v).type= "+((Dodge)v).type);

        Bmw bmw = new Bmw();
        
        System.out.println("Bmw.getTypeStatic()= "+Bmw.getTypeStatic()); */

        //
        //Overloading methods test
        //
        /*Car hybridCar=HybridCar.getInstance();
        Car car = new Dodge();
        hybridCar.setPropertiesAsConcreteAuto((Dodge)car);*/

        //
        //Test Casting
        //
        /*Car[] cars={new Dodge(),HybridCar.getInstance(), new Bmw()};
        for (Car  c:cars) {
            System.out.println(c.getClass().getName());
            if (c instanceof HybridCar) {
                ((HybridCar)c).setCarProperties(c);
                System.out.println(((HybridCar)c).getCarProperties().toString());
            }
        }*/
        //
        //Test constructors
        //
        Bmw bmw1= new Bmw();
        
        Bmw bmw2= new Bmw("Simple bmw");
        Bmw bmw3 = new Bmw("Tuning bmw",1201);
        System.out.println("****************Printing orderNo****************");
        System.out.println("bmw1 orderNo= "+bmw1.getOrderNo());
        System.out.println("bmw2 orderNo= "+bmw2.getOrderNo());
        System.out.println("bmw3 orderNo= "+bmw3.getOrderNo());

    }
}
