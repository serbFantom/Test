package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 09.02.2010
 */
public class SerbThread2 implements Runnable {

    public void run() {
        for (int x = 1; x <= 10; x++) {
            try {
                //for test purposes
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run by "+Thread.currentThread().getName() + ", x is " + x);
        }
    }

}
