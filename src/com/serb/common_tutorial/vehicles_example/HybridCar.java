/**
 * User: SBezugliy
 * Date: 03.09.2008 16:41:28
 */
package com.serb.common_tutorial.vehicles_example;

public class HybridCar extends Car {

    private Vehicle carProperties;

    private static HybridCar ourInstance = new HybridCar();

    public static HybridCar getInstance() {
        return ourInstance;
    }

    public void setCarProperties(Vehicle auto) {
        carProperties=auto;
    }

    public void setPropertiesAsConcreteAuto(Bmw bmw) {
        System.out.println("setPropertiesAsConcreteAuto(Bmw bmw)");
        carProperties=bmw;
    }

    public void setPropertiesAsConcreteAuto(Dodge dodge) {
        System.out.println("setPropertiesAsConcreteAuto(Dodge dodge)");
        carProperties=dodge;
    }

    public void setPropertiesAsConcreteAuto(Car car) {
        System.out.println("HybridCar.setPropertiesAsConcreteAuto(Car car)");
        carProperties=car;
    }

    public Vehicle getCarProperties() {
        return carProperties;
    }

    private HybridCar() {
        //
    }

    public void goUpHill() {

    }

    public void move() {

    }

    public void moveB() {

    }

    public void moveA() throws Exception {

    }

    Bmw go(int i) {
        return new Bmw();
    }

    public String someMeth() {
        return null;
    }
}
