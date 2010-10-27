package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 25.03.2008
 */
public class AnonimClassesTutorial {
    public Contents cont() {
        return new Contents() {
            private int i = 11;
            public int value() { return i; }
            //
            public String getInfo() {
                return "This is anonim Content Info";
            }
        }; 
    }
    public static void main(String [] args) {
        System.out.println("Anonim class test");
        AnonimClassesTutorial thisClazz=new AnonimClassesTutorial();
        Contents cont=thisClazz.cont();
        System.out.println("******cont= "+cont.value());
        System.out.println("******Contents.getInfo()= "+cont.getInfo());
    }
}
