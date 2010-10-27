package com.serb.threads;

import java.util.concurrent.TimeUnit;

/**
 * User: SBezugliy
 * Date: 18.02.2010
 */
public class Operator extends Thread {

    public void run() {
        System.out.println("Start Machine Thread");
        while (true) {
            System.out.println("Operator Get shape from user...");
            synchronized (this) {
                System.out.println("Calculate new machine steps from shape...");
                try {
                    TimeUnit.MILLISECONDS.wait(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }
    }
}
