package com.serb.serialization;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 09.06.2009
 */
public class Cat implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
