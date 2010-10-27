package com.serb.threads;

import java.util.concurrent.Callable;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id=id;
    }

    public String call() throws Exception {
        return null;  
    }
}
