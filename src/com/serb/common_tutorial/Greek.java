package com.serb.common_tutorial;

/**
 * User: sbezugliy
 * Date: 04.03.2010
 */
public class Greek{

     int i=1;

     public int getI(){
          System.out.print("Super");
          return i;
     }

     public static void main(String arhs[]){
          Greek ga=new Arabik();
          System.out.print(ga.i+" "+ga.getI());
     }
}

class Arabik extends Greek{

     int i=2;

     public int getI(){
          System.out.print("Sub");
          return i;
     }

}