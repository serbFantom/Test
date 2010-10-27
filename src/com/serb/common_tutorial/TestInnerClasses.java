package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 08.08.2008 10:34:50
 */
public class TestInnerClasses {
    String mainStr="mainStr";
    public void printInfo() {
        final String s="str";
        class InMethod {
            public void printInner() {
                System.out.println("Inner class s= "+s);
                System.out.println("Inner class mainStr= "+mainStr);
            }
        }
    }
    public class InClass {
        public void printInner() {
            //System.out.println("Inner class s= "+s);
            System.out.println("Inner class mainStr= "+mainStr);
        }
    }

    public InClass getInClass() {        
        InClass ic=new InClass();
        return ic;
    }

    public static void main(String[] args) {
        TestInnerClasses tic = new TestInnerClasses();
        InClass ic=tic.getInClass();
    }
}
