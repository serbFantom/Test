package com.serb.gc;

import java.util.Date;

/**
 * User: SBezugliy
 * Date: 06.02.2009 11:00:16
 */
public class CheckGC {
    
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("--------------------CheckGC FINALIZE-----------------------");

    }
    int doX(Integer x, Integer y) { return 3; }
    
    public static void main(String [] args) {
        CheckGC checkGC=new CheckGC();
        short s=1;
        //checkGC.doX(s,s);
        
       /* try {
            checkGC.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/

        checkGC=null;
        CheckGC checkGC2=new CheckGC();
        //this will run finalize method of CheckGC class
        checkGC2=null;

        Runtime rt = Runtime.getRuntime();
        System.out.println("Total JVM memory: "
                + rt.totalMemory());
        
        //Writing Code That Explicitly Makes Objects Eligible for Collection (Exam Objective 7.4) 251
        //252 Chapter 3: Assignments
        System.out.println("Before Free Memory = "
                + rt.freeMemory());

        Date d = null;
        for(int i = 0;i<100000;i++) {
            d = new Date();
            d = null;
        }
        System.out.println("After Free Memory = "
                + rt.freeMemory());
        rt.gc(); // an alternate to System.gc()
        System.gc();
        System.out.println("!!!!!!!!After GC Free Memory = "
                + rt.freeMemory());        
    }
}
