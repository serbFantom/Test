package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class TestSyncronize extends Thread {
    private StringBuffer strBufVal;
    private Pipe pipe;
    public TestSyncronize(Pipe pipe) {
        this.pipe=pipe;
    }
    public void run() {
        pipe.forward();
    }
}
