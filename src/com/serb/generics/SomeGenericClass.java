package com.serb.generics;

/**
 * User: SBezugliy
 * Date: 24.12.2009
 */
public class SomeGenericClass<t extends Animal> {
    private Animal animal;

    public SomeGenericClass(t ref) {
        this.animal = ref;
        System.out.println(animal);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
