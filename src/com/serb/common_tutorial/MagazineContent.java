package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 25.03.2008
 */
public class MagazineContent implements Contents {
    private static MagazineContent _this=null;

    private MagazineContent() { }
    private int value=20;
    public int value() {
        return value;
    }
    public static MagazineContent getMagazineContent() {
        if (_this==null) {
            return new MagazineContent();
        }
        return _this;
    }
    public String getInfo() {
        return "This is Magazine Content Info";
    }
}
