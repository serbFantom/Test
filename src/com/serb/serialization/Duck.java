package com.serb.serialization;

import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.IOException;
import java.io.ObjectInput;

/**
 * Created by SBezugliy
 * Date: 26.10.2009
 */
public class Duck extends Animal implements Externalizable {
    private int weight;
    private int size;
    private static final long serialVersionUID = -8960591368696389613L;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /*public Duck (String name) {
        //default parameters
        this.name=name;
        size=10;
    }*/

    //todo:realize it

    public void writeExternal(ObjectOutput out) throws IOException {

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
