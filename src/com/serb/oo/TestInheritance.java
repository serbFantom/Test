package com.serb.oo;

/**
 * User: SBezugliy
 * Date: 22.04.2009 14:26:19
 */
public class TestInheritance {
    public static void main(String[] args) {
        Parent child = new Child();
        Receiver advancedReceiver = new AdvancedReceiver();
        advancedReceiver.receive(child);
        //new Child().printX();
        child.printX();
        int[][] s=new int[3][4];
        System.out.println();
    }
}

class AdvancedReceiver extends Receiver {
    public void receive(Child c) {
        System.out.println("AdvancedReceiver");
        c.outMe();
    }
}