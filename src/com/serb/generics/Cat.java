package com.serb.generics;

/**
 * User: SBezugliy
 * Date: 08.12.2009
 */
public class Cat extends Animal{
    @Override
    public void checkup() {
        System.out.println("Cat checkup");
    }

    public String toString() {
        return "Cat class";
    }
}
