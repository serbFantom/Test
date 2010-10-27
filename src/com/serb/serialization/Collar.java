package com.serb.serialization;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 09.06.2009
 */
public class Collar extends SomeObj {//implements Serializable
    private int collarSize;

    public Collar(int size) {
        collarSize = size;
    }

    public int getCollarSize() {
        return collarSize;
    }
}
