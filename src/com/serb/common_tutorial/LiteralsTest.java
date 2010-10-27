package com.serb.common_tutorial;

import java.util.Date;

/**
 * User: SBezugliy
 * Date: 08.09.2008 16:15:14
 */
public class LiteralsTest {
    static int octI=011;

    static int globalVar;

    static int dexI = 0X0001;
    static int [] year = new int[100];

    static LiteralsTest[] literalTestArr = new LiteralsTest[20];

    static char charC = (char) 98; // Ridiculous, but legal

    static char c = '\"'; // A double quote
    static char d = '\n'; // A newline
    
    static {
        System.out.println("*************LiteralsTest****************");
        System.out.println("Static initialization block");
    }

    public static void main(String [] args) {
        System.out.println("octI= "+octI);
        System.out.println("dexI= "+dexI);
        System.out.println("charC= "+charC);
        System.out.println("c= "+c);
        System.out.println("d= "+d);
        //
        byte b = 3; // No problem, 3 fits in a byte
        byte c = 8; // No problem, 8 fits in a byte
        byte d = (byte)(b + c); // Should be no problem, sum of the two bytes fits in a byte
        //
        double doubleValue= 2.78;
        float floatValue= 2.78F;
        int intValue=0;
        intValue-=c;
        //intValue=(int)doubleValue;
        //intValue=(int)floatValue;
        System.out.println("intValue= "+intValue);
        //
        float f = 234.56F;
        short s = (short)f;
        System.out.println("s= "+s);

        /*for (int i=0;i<year.length;i++) {
            System.out.println("year["+i+"]= "+year[i]);
        }*/
        int localVar;
        //System.out.println("localVar= "+localVar);
        System.out.println("globalVar= "+globalVar);
        /*for (int i=0;i<literalTestArr.length;i++) {
            System.out.println("literalTestArr["+i+"]= "+literalTestArr[i]);
        }*/
        Date date=null;
        if (date == null) {
            System.out.println("date is null");
        }

        //int y=ReferenceTest.staticRef1;

        ReferenceTest refTst1=new ReferenceTest();
        ReferenceTest refTst2=new ReferenceTest();
        printOtherInfo();

    }

    public static void printOtherInfo() {
        int x = (int)(2.0/1.5);
        System.out.println("Test x= "+x);
        long l = 130L;
        byte b = (byte)l;
        System.out.println("The byte is " + b);
        //Create a float number type of any value, and assign it to a short using casting.
        //1. Declare a float variable: float f = 234.56F;
        //2. Assign the float to a short: short s = (short)f;
        float f = 234.56F;
        short s = (short)f;
        System.out.println("f= "+f);

        byte bi = 3; // No problem, 3 fits in a byte
        byte c = 8; // No problem, 8 fits in a byte
        //byte d =+ (bi + c); // Should be no problem, sum of the two bytes fits in a byte
    }
}
