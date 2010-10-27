package com.serb.common_tutorial;

import java.util.*;

/**
 * User: sbezugliy
 * Date: 01.08.2008
 * Time: 13:34:56
 */
public class Animal implements Cloneable {
    private String name;
    private String age;

    public int num;

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public  void setName(String name) {
        this.name=name;
    }

    public void setAge(String age) {
        this.age=age;
    }

    public static void printClassName() {
        System.out.println("Class= "+Animal.class.getName());
    }

    public static void modifyAnimal(Animal animal, String name) throws CloneNotSupportedException {
        Animal animalTmp=null;
        //try {
            animalTmp=(Animal)animal.clone();
            //animalTmp=animal;
        //} catch (CloneNotSupportedException e) {
            //throw new RuntimeException(e);
        //}
        animal.setName(name);
        name="New name";
        animal=new Animal();
        animal.setName("Modified name");
        //animalTmp.setName(name);
    }

    public void modifyInt(Integer i) {
        i=new Integer(1000);
    }

    public int hashCode() {
        return num/2;
    }
    private void someMethod() {
        Set st1=new LinkedHashSet();
        Map mp=new TreeMap();//new LinkedHashMap();
        

        try {
            System.exit(3);
        } finally {
            System.out.println("someMethod finally block");
        }
    }
}
