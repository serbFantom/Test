package com.serb.generics;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * User: SBezugliy
 * Date: 08.12.2009
 */
public class TestGenerics {

    private String type="Test";

    public static void main(String[] args) {

        TestGenerics tstGeneric = new TestGenerics();
        //Test generic in collections
        List<Dog> dogList = new ArrayList<Dog>();
        dogList.add(new Dog());
        tstGeneric.checkAnimals(dogList);

        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(new Bird());
        tstGeneric.checkAnimals(animalList);

        List<Dog> dogList2 = new ArrayList<Dog>();
        tstGeneric.makeArrayList(new Dog());
        System.out.println("dogList2= "+dogList2);
        //System.out.println("tstGeneric.makeArrayLst(new Dog())= "+dogList2);

        System.out.println("tstGeneric= "+tstGeneric);

        //Test generic in usual classes
        SomeGenericClass someTst= new SomeGenericClass<Animal>(new Dog());
        SomeGenericClass someTst2= new SomeGenericClass<Animal>(new Bird());
    }

    public void addAnimal(List<Animal> animals) {
        animals.add(new Dog()); // still OK as always
    }

    public void checkAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public void checkAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public <T> void makeArrayList(T t) { // take an object of an
        // unknown type and use a
        // "T" to represent the type
        List<T> list = new ArrayList<T>(); // now we can create the
        // list using "T"
        list.add(t);
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
                append("Generic", "Generic").
                append("type", type).
                toString();
    }

}
