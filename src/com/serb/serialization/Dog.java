package com.serb.serialization;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 09.06.2009
 */
public class Dog implements Serializable {

    private Collar theCollar;

    private transient int dogLength = 10;

    protected static int dogsCount=100;
    
    public transient SomeObj someObj=new SomeObj();    

    private int dogSize;

    public String name;

    private static final long serialVersionUID = -7991238878161939695L;

    public int getDogSize() {
        return dogSize;
    }

    public void setDogSize(int dogSize) {
        this.dogSize = dogSize;
    }

    public Dog(Collar collar, int size) {
        theCollar = collar;
        dogSize = size;
    }

    public Dog (String name) {
        this(new Collar(1),1);
        this.name=name;
    }

    public void setTheCollar(Collar theCollar) {
        this.theCollar = theCollar;
    }

    public int getDogLength() {
        return dogLength;
    }

    public void setDogLength(int dogLength) {
        this.dogLength = dogLength;
    }

    public Collar getCollar() {
        return theCollar;
    }

    /*private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeInt(this.getCollar().getCollarSize());
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        int collarSize = is.readInt();
        Collar col = new Collar(collarSize);
        //Collar col=(Collar)is.readUnshared();
        this.setTheCollar(col);
    }*/
}
