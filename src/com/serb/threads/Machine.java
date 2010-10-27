package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 18.02.2010
 */
public class Machine extends Thread {
    Operator operator; // assume this gets initialized

    public Machine (Operator operator) {
        this.operator=operator;
    }

    public void run() {
        System.out.println("Start Machine Thread");
        while (true) {
            synchronized (operator) {                
                try {
                    operator.wait();
                } catch (InterruptedException ie) {
                }
                System.out.println("Send machine steps to hardware...");
            }
        }
    }
}
