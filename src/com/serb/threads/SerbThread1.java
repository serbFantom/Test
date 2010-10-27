package com.serb.threads;

import java.util.concurrent.TimeUnit;

/**
 * User: SBezugliy
 * Date: 09.02.2010
 */
public class SerbThread1 implements Runnable {

    public void run() {
        synchronized (this) {
            try {
            //old style
            //Thread.sleep(2*1000);
            //new style SE5                
            TimeUnit.MILLISECONDS.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();            
            System.out.println("SerbThread1 run() method started!");
            System.out.println("Run by "+ Thread.currentThread().getName());
        }        
    }
}
