package com.serb.sorting.opreg_test;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by sbezugliy
 * Date: 30.09.2009
 */
//TODO:delete it
public class Main {

    private static Random randomGenerator;

    static {
        randomGenerator=new Random();
    }

    public static void main(String[] args) {
        System.out.println("Start search");
        long time = System.nanoTime();
        List<PendingMessageRow> exactlyPairs=generateRandomPendingList(40000);
        System.out.println("List generated " +
                ". Processed in (" + (System.nanoTime() - time)/1000000 + " ms)");

        System.out.println("Start processing...");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------");
        PendingMessageRow validMessage=generateRandomPendingList(1).get(0);
        time = System.nanoTime();
        for (int i =0; i<50000;i++) {
            isEarlierMessage(validMessage,exactlyPairs);
        }

        System.out.println("isEarlierMessage " +
                ". Processed in (" + (System.nanoTime() - time)/1000000 + " ms)");
        System.out.println("End search");
    }

    public static List<PendingMessageRow> generateRandomPendingList(int count) {
        List<PendingMessageRow> generatedList =new ArrayList<PendingMessageRow>();
        for (int i=0;i<count;i++) {
            PendingMessageRow row=new PendingMessageRow();
            row.setNumber1(randomGenerator.nextLong());
            row.setNumber2(randomGenerator.nextLong());
            TNB orignTnb=new TNB();
            orignTnb.setOid(randomGenerator.nextLong());
            TNB releasingTnb=new TNB();
            releasingTnb.setOid(randomGenerator.nextLong());
            row.setOrignTnb(orignTnb);
            row.setTnbReceiving(orignTnb);
            row.setTnbReleasing(releasingTnb);
            row.setOid(randomGenerator.nextLong());
            row.setPortingDate(new Date());
            generatedList.add(row);
        }
        return generatedList;
    }

    /*private static long getRandomLong () {
        return randomGenerator.nextLong();
    }*/

    private static boolean isEarlierMessage(PendingMessageRow validMessage, List<PendingMessageRow> exactlyPairs) {
        long number1=validMessage.getNumber1();
        long number2=validMessage.getNumber2();
        long tnbReleasing=validMessage.getTnbReleasing().getOid();
        Date portingDate=validMessage.getPortingDate();
        for (PendingMessageRow processedMessage:exactlyPairs) {
             if (number1==processedMessage.getNumber1()&&
                 number2==processedMessage.getNumber2()&&
                 tnbReleasing==processedMessage.getTnbReleasing().getOid()&&
                 isTnbRecievingEquals(validMessage,processedMessage) &&
                 portingDate.compareTo(processedMessage.getPortingDate())<0 ) {
                return true;
             }
        }
        return false;
    }

    private static boolean isTnbRecievingEquals(PendingMessageRow message1, PendingMessageRow message2) {
        if (message1.getTnbReleasing()!=null&&message2.getTnbReleasing()!=null) {
            return message1.getTnbReleasing().getOid()==message2.getTnbReleasing().getOid();
        }
        return true;
    }
}
