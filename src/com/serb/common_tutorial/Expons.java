package com.serb.common_tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: S.Bezuglyi
 * Date: Oct 20, 2010
 * Time: 3:04:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Expons{

     static Stores st;

     public static void main(String argv[]){
          st=new Stores();
          Object ob1=getFormattedObject(Pattern.compile("H[a-d][k-m]"), "H[a-b][k-m]");
          Object ob2=getFormattedObject(st.pt1.matcher("Hello Hallo"), "[a-e][l]lo");
          Object ob3=getFormattedObject(null);
          System.out.println(ob3);
     }

     public static Object getFormattedObject(Object ob, String... s){
          if (ob instanceof Pattern){
               st.pt1=((Pattern)ob).compile(s[0]);
               return null;
          }else if (ob instanceof Matcher){
               st.mt1=(Matcher)ob;
               return null;
          }else{
               st.mt1.find();
               st.st1=st.mt1.group();
               return st.st1;
          }
     }

}

class Stores{
     Pattern pt1; Matcher mt1; String st1;
}