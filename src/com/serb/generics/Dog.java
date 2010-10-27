package com.serb.generics;

/**
 * User: SBezugliy
 * Date: 08.12.2009
 */
public class Dog extends Animal{
    @Override
    public void checkup() {
        System.out.println("Dog checkup");
    }

    public String toString() {
        return "Dog class";
    }
}
