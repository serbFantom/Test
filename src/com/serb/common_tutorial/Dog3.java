package com.serb.common_tutorial;


/**
 * User: SBezugliy
 * Date: 05.02.2009 16:48:32
 */
public class Dog3 extends Animal{

    public void dogEat() {
        System.err.println("dogEat");
    }
    
    void go(Animal a) { 
        System.err.println("Dog3 go method");
    }

    void go(Object o) {

    }

    public  void setName(String name)  {
        String s="str";
        System.out.println(name);
    }

    static void wide_vararg(long... x) { 
        System.out.println("long...");
    }
    static void box_vararg(Integer... x) {
        System.out.println("Integer..."+x);
    }

    public static void main(String[] args) {
        Dog3 d = new Dog3();
        Animal a = new Dog3();
        d.go(a); // is this legal ?
        int i= 10;
        d.go(i);
        //d.test(new Integer(1));
        wide_vararg(); // needs to widen and use var-args
        box_vararg(5,5); // needs to box and use var-args
        box_vararg(new Integer[10]); // needs to box and use var-args
        box_vararg(5,5,10,30);
    }

    void test(Long x) {
    }

    protected void someMethod() {
        try {
            System.exit(3);
        } finally {
            System.out.println("someMethod finally block");
        }
    }

    private final void someMethod2() {
            
    }
}
