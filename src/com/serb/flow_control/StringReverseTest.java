package com.serb.flow_control;

/**
 * User: SBezugliy
 * Date: 18.02.2009 17:53:15
 */
import java.lang.reflect.Field;

/**
 * This application demonstrates how to modify java.lang.String object
 * through reflection API.
 *
 * @version 1.0
 * @author Eugene Matyushkin
 */
public class StringReverseTest {

    /**
     * final static string that should be modified.
     */
    public static final String testString = "abcde";

    public static void main(String[] args) {
        try{
            System.out.println("Initial static final string:  "+testString);
            Field[] fields = testString.getClass().getDeclaredFields();
            Field value = null;
            for(int i=0; i<fields.length; i++){
                Field field = fields[i];
                if (field.getType().equals(char[].class)){
                    value = field;
                    break;
                }
            }
            if (value == null){
                System.err.println("value wasn't found!");
                return;
            }
            value.setAccessible(true);  // 1.
            char[] charValue = (char[])value.get(testString);
            for(int i=0; i<charValue.length/2; i++ ){
                char tmp=charValue[i];
                charValue[i] = charValue[charValue.length-1-i];
                charValue[charValue.length-1-i] = tmp;
            }
            value.set(testString, charValue);
            System.out.print("Reversed static final string: ");
            System.out.println(testString);
        } catch (Throwable th){
            System.err.println("Exception: "+th);
            th.printStackTrace();
        }
    }
}
