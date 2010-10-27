package com.serb.generics;

/**
 * User: SBezugliy
 * Date: 08.12.2009
 */
public class Bird extends Animal{
    @Override
    public void checkup() {
        System.out.println("Bird checkup");
    }
    public String toString() {
        return "Bird class";
    }
}
