package com.serb.common_tutorial;

import org.apache.log4j.Logger;

/**
 * User: SBezugliy
 * Date: 12.09.2008 11:54:53
 */
public class ReferenceTest {
    private int ref1;
    public static int staticRef1;

    Animal myAnimal=new Animal();
    private static Logger log=Logger.getLogger(ReferenceTest.class.getName());
    static int size = 7;

    static int [] x = new int[4];

    static {
        /*try {
            x[4] = 5;// bad array index!
        } catch (Exception ex) {
            System.err.println("!!!!Static initializer does not finished properly");
            ex.printStackTrace();
        }*/
        /*Animal animal=new Animal();
        try {
            Animal.modifyAnimal(animal,"some name");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/


    }


    static {
        System.out.print("*************ReferenceTest**************** ");
        System.out.println("Static initialization block");
    }

    public ReferenceTest() {
        System.out.println("***************************ReferenceTest constructor");
    }

    {
        System.out.print("*************ReferenceTest**************** ");
        System.out.println("!! Non static initialization block 1");
        //x[4] = 5;// bad array index!
        int initVar1=10;

        ref1=1000;
    }


    static void changeIt(int size) {
        size = size + 200;
        System.out.println("size in changeIt is " + size);
    }

    void changeMyAnimal (Animal myAnimal) {
        myAnimal.num = 99;
        System.out.println("myAnimal.num in changeMyAnimal is " + myAnimal.num);
        myAnimal = new Animal();
        myAnimal.num = 420;
        System.out.println("myAnimal.num in changeMyAnimal is now " + myAnimal.num);
    }

    void takesAnArray(int [] someArray) {
    // use the array parameter
    }


    public static void main(String[] args) {
        //Appender ap= new Appender();
        //log.addAppender();        
       /* PropertyConfigurator.configure("E:\\Projects\\common_training\\conf\\logging.properties");
        //log.
        log.error("Error Something");
        log.error("Error Something2");
        log.error("Error Something4");
        log.info("Error Info1");
        String s = "Fred";
        System.out.println("Before assigns s= "+s);
        String t = s; // Now t and s refer to the same
        // String object
        t.toUpperCase(); // Invoke a String method that changes the String
        System.out.println("After assigns s= "+s);
        System.out.println("t= "+t);
        //System.getProperties().
        Runtime.getRuntime().gc();
        System.out.println("------Exit-----");*/
        /*if(this.CreateInputClass.Note!=null)
            if(this.CreateInputClass.Note.length() > 99)
                this.CreateInputClass.Note= this.CreateInputClass.Note.substring(0,99);*/
        //String str="123456";
        //System.err.println(""+str.substring(0,6)+"length= "+str.length());
        //long d=System.currentTimeMillis();
       
           //Thread.sleep(5*60*1000);
        //while (true) {
            
            //System.out.println(System.currentTimeMillis()-d);
        //}
        //ReferenceTest refTest=new ReferenceTest();
        //System.out.println("refTest.ref1= "+refTest.ref1);




        String[][] strArr;//=new String[][] {new String[]{"12","12"},new String[]{"12","12"}};
        //if
        int [] year;// = new int[100];
        //if 
        /*for(int i=0;i<100;i++) {
            System.out.println("year[" + i + "] = " + year[i]);
        }*/

        Animal animal1=new Animal();
        Animal animal2=new Animal();
        //animal1.modifyObject();
        try {
            animal1.modifyAnimal(animal2,"Some name");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  
        }
        System.out.println("animal2= "+animal2.getName());
        Integer i= new Integer(0);
        System.out.println("i before modify= "+i.intValue());
        animal1.modifyInt(i);
        System.out.println("i after modify= "+i.intValue());
        int a =7;
        ReferenceTest.changeIt(a);
        System.out.println("ReferenceTest.size= "+ReferenceTest.size);
        System.out.println("size= "+size);

        //
        //Test shadowing
        //
        System.out.println("********************Test shadowing********************");
        ReferenceTest refTst = new ReferenceTest();

        System.out.println("refTst.myAnimal.num is " + refTst.myAnimal.num);
        refTst.changeMyAnimal(refTst.myAnimal);
        System.out.println("refTst.myAnimal.num after changeMyAnimal is " + refTst.myAnimal.num);
        //refTst.takesAnArray(new int[]{1,2});
        int[] arr1=new int[4];
        char[] arr2=new char[4];
        //arr1=((int[])(arr2));
        Animal anim=new Animal();
        Animal[] animArr=new Animal[2];
        //anim=animArr;
        //Boolean b = new Boolean("TRUE");
        //if (!b) {
        Boolean b=null;
            System.out.println("wrapper class Boolean b = "+b);
        //}
        Integer i2=Integer.valueOf("0011",10);
        int i3=Integer.valueOf("0011",10);
        System.out.println("wrapper class Integer i2= "+i2);

        String hexStr=Integer.toHexString(11);
        System.out.println("hexStr= "+hexStr);

        String binStr=Integer.toBinaryString(255);
        System.out.println("binStr= "+binStr);

        String octStr=Integer.toOctalString(254);
        System.out.println("octStr= "+octStr);
        //Integer.p

        long i4 = 5;
        go(i4); // which go() will be invoked?

        byte i5=10;
        double s=1.4;
        go((int)s);

        go2(1,1,1);
        Integer h=null;
        go2(h);



    }


    static void go2(Integer... y) {
        System.out.println("-----------------------"+y.getClass());

        System.out.println("Number of arguments= " +y.length);


    }

    static void go(int x) {
        System.out.println("Integer");
    }

    static void go(long x) {
        System.out.println("long");
    }

    static void go(byte... x) {
        System.out.println("byte... ");
    }
    
    {
        System.out.print("*************ReferenceTest**************** ");
        System.out.println("!! Non static initialization block 2");
    }
}
