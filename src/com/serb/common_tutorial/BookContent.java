package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 25.03.2008
 */
public class BookContent implements Contents{
    private int value=10;
    public int value() {
        return value;  
    }
    public String getInfo() {
        return "This is Book Conten Info";
    }
}
