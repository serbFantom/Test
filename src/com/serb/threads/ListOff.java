package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class ListOff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final static int id=taskCount++;

    public ListOff() {

    }

    public ListOff(int countDown) {
        this.countDown=countDown;
    }

    public String status() {
        return "id"+"("+(countDown>0?countDown:"LiftOff!")+"), ";
    }

    public void run() {
        while (countDown-->0) {
            System.out.print(status());
            Thread.yield();
        }
        //System.out.println();
    }
}
