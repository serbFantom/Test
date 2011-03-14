package com.serb.sorting;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 14.07.2008
 * Time: 18:47:15
 */
public class TestSortingArrays {
    protected double i234;

    private final static int SIZE = 100000000;
	private final static int MAX = 10000000;


    public static void main(String args[]) {
        /*Object o="=";
        System.out.print("="+null);
        byte b=1;
        long m=-b;
        System.out.print("m"+o+m);
        //
        String arrayA[]={"a","b","c","d","f","g","h"};
        revertArray(arrayA);
        findUniqueValues();*/

        //reverseString("abcdefgh");
        //reverseString2("abcdefgh");
        //reverseString3("abcdefgh");
        
        //reverseString4("abcdefgh");
        Random rand = new Random();
        int[] numbers = new int[SIZE];
        for (int i=0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(MAX);
        }
        QuickSortTest quickSort = new QuickSortTest();
        boolean printValues = false;
        quickSort.sort(numbers, printValues);//new int[] {10, 6, 7, 1, 2, 3, 4, 8, 9, 5}                
    }

    void someMethod () {

    }


    protected void someMethod2 () {

    }
    


    public static void printArray(Object[] arr) {
        for (int i=0;i<arr.length;i++){
            if (arr.length-1!=i) {
                System.out.print(arr[i]+",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }

    /**
     *
     * @param arr
     */
    public static void revertArray (String[] arr) {
        //Thread.currentThread().getClass();
        System.out.println("***********Initial array*************");
        printArray(arr);

        String arrayB[]=new String[arr.length];
        for (int i=arrayB.length-1;i>=0;i--){            
            arrayB[arrayB.length-1-i]=arr[i];
        }

        System.out.println("***********Revert array*************");
        printArray(arrayB);

    }

    public static void findUniqueValues() {

        System.out.println("***********Enter findUniqueValues*************");
        final int ARRAY_SIZE  = 1024*1024;
        final int RANDOM_SIZE = 10;

        Integer[] inputArray = new Integer[ARRAY_SIZE];
        Random randomizer = new Random();
        for (int i=0;i<inputArray.length;i++){
            inputArray[i] = randomizer.nextInt(RANDOM_SIZE);
        }

        // 1 version

        long time = System.nanoTime();

        List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(inputArray));
        List<Integer> outputList = new ArrayList<Integer>();
        for (Integer elem: inputList){
            if (!outputList.contains(elem) &&
                    (inputList.indexOf(elem) == inputList.lastIndexOf(elem))
                    ){
                outputList.add(elem);
            }
        }
        System.out.println("First version result = " + outputList.size() +
                ". Processed in (" + (System.nanoTime() - time)/1000000 + " ms)");

        // 2 version

        time = System.nanoTime();

        List<Integer> outputList1 = new ArrayList<Integer>();

        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length; i++)
            if (!inputArray[i].equals(inputArray[i > 0 ? i - 1 : inputArray.length-1])
                    && !inputArray[i].equals(inputArray[i < inputArray.length - 1 ? i + 1 : 0]))
                outputList1.add(inputArray[i]);
        System.out.println("Second version result = " + outputList1.size() +
                ". Processed in (" + (System.nanoTime() - time)/1000000 + " ms)");

        // Third version.

        time = System.nanoTime();

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (Integer s : inputList){
            Integer count = m.get(s) == null ? 0 : m.get(s);
            m.put(s, count + 1);
        }

        Set<Map.Entry<Integer, Integer>> s = m.entrySet();
        List<Integer> unqList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> e : s){
            if (e.getValue() == 1)
                unqList.add(e.getKey());
        }

        System.out.println("Third version result = " + unqList.size() +
                ". Processed in (" + (System.nanoTime() - time)/1000000 + " ms)");


        System.out.println("***********Exit findUniqueValues*************");
    }

    public static void reverseString (String strSource) {
        System.out.println("***********Revert string*************");
        int strLength=strSource.length();
        StringBuffer strBuff= new StringBuffer();

        for (int i=strLength-1;i>=0;i--) {
            strBuff.append(strSource.charAt(i));
        }

        char[] strSourceArr=strSource.toCharArray();
        for (int i=0;i<strSourceArr.length/2;i++) {
            char tmp=strSourceArr[i];
            strSourceArr[i]=strSourceArr[strSourceArr.length-1-i];
            strSourceArr[strSourceArr.length-1-i]=tmp;
        }

        String reverseStr=new String(strSourceArr);
        System.out.println("Result of manual reverse strSource= "+strBuff.toString());
        System.out.println("Result of using strBuff.reverse() method= "+strBuff.reverse().toString());
        System.out.println("Result of using char array= "+reverseStr);
        
    }
   private static void reverseString2(String strSource) {
        System.out.println("***********Reverse string 2 version simple*************");
        System.out.println("Before sorting strSource= "+strSource);
        char[] charArray=strSource.toCharArray();
        char[] charArray2=new char[charArray.length];
        for (int i=charArray.length-1;i>=0;i--) {
            /*char tmp=charArray[i];
            charArray[i]=charArray[charArray.length-1-i];
            charArray[charArray.length-1-i]=tmp;*/
            charArray2[charArray.length-1-i]=charArray[i];
        }
        strSource=new String(charArray2);
        System.out.println("After sorting strSource= "+strSource);
    }

    private static void reverseString3(String strSource) {
        System.out.println("***********Reverse string 3 version simple*************");
        System.out.println("Before sorting strSource= "+strSource);
        StringBuilder strBuilder=new StringBuilder();
        int len=strSource.length();
        for (int i=(len-1);i>=0;i--) {
            strBuilder.append(strSource.charAt(i));    
        }
        System.out.println("After sorting strSource= "+strBuilder);
    }


    private static void reverseString4(String strSource) {
        System.out.println("***********Reverse string 4 version simple*************");
        System.out.println("Before sorting strSource= "+strSource);
        int len=strSource.length();
        char[] charArr=strSource.toCharArray();
        for (int i=0;i<len/2;i++) {
            char tmp=charArr[i];
            charArr[i]=charArr[len-1-i];
            charArr[len-1-i]=tmp;
        }
        System.out.println("After sorting strSource= "+new String(charArr));
    }




}
