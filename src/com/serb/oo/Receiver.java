package com.serb.oo;

/**
 * Created by SBezugliy
 * Date: 21.10.2009
 */
class Receiver {
    public void receive(Parent p) {
        System.out.println("Receiver");
        p.outMe();
        String str = new StringBuilder().append("sdfklsdjfkl").append("sdsfsda").append("sdfklsdjfkl").append("sdsfsda")
                .append("sdfklsdjfkl").append("sdsfsda").append("sdfklsdjfkl").append("sdsfsda").append("sdfklsdjfkl")
                .append("sdsfsda").toString();
    }
}
