package com.serb.flow_control;

/**
 * User: sbezugliy
 * Date: 12.02.2009 11:06:52
 */
public class ExceptionsTest {

    public static void main (String[] args) {
        String str =readData();

        System.out.println("str= "+str);
        /*try {
            myExceptionTest();
        } catch (MyException e) {
            e.printStackTrace();  
        }*/
        //myErrorTest();
    }

    static String readData() {
        try {
            /*RandomAccessFile raf =
                    new RandomAccessFile("myfile.txt", "r");
            byte b[] = new byte[1000];
            raf.readFully(b, 0, 1000);*/
            String s="abcdefgh";
            String reverseStr = "";
            StringBuffer strBuf=new StringBuffer("");
            for(int i=s.length()-1;i>=0;--i) {
                //reverseStr += s.charAt(i);
                strBuf.append(s.charAt(i));
            }
            return strBuf.toString();

            //return "1";
        }
        /*catch(FileNotFoundException e) {
            System.err.println("File not found");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "2";
        }

        catch(IOException e) {
            System.err.println("IO Error");
            System.err.println(e.toString());
            e.printStackTrace();
            return "2";
        }*/ finally {
            System.out.println("!!!!!!!!!!!!!Finally block");
        }

    }
    
    static void myExceptionTest() throws MyException {
        try {
            throw new MyException();
        }
        catch(MyException me) {
            throw me;
        }
    }

    static void myErrorTest() {
        try {
            throw new MyError();
        } catch (MyError myErr) {
            myErr.printStackTrace();
        }
    }

    static void sortArrayInt(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            //
        }
    }

    public static void tst(){

    }


}
