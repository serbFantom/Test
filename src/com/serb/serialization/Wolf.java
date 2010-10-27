package com.serb.serialization;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 15.06.2009
 */
public class Wolf extends Animal implements Serializable {

    //private String name;

    public Wolf() {
        this.name="wolf";
    }

    public String getName() {
        return this.name;    
    }
}
