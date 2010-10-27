package com.serb.dates;

import java.util.Calendar;
import java.util.Date;

/**
 * Class for showing some aspects working with java dates
 *
 * User: SBezugliy
 * Date: 14.05.2009 16:36:06
 */
public class TestDates {

    public static void main(String[] args) {
        //testSomething();
        //testCalendar();
        test();
    }

    static void testSomething() {
        System.out.println("----------------------------------testSomething()");
        Calendar test1=Calendar.getInstance();
        test1.setTime(new Date());
        System.out.println("--------------------");
        Runtime.getRuntime().freeMemory();
        System.out.println("Thread.currentThread().getId()= "+Thread.currentThread().getId());
        System.out.println("Thread.currentThread().getPriority()= "+Thread.currentThread().getPriority());
        System.out.println("Thread.currentThread().getThreadGroup().activeCount()= "+Thread.currentThread().getThreadGroup().activeCount());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calendar test2=Calendar.getInstance();
        test2.setTime(new Date());
        System.out.println("test1.getTime()= "+test1.getTime());
        System.out.println("test2.getTime()= "+test2.getTime());
        System.out.println("test1.getTime().before(test2.getTime())= "+test1.getTime().before(test2.getTime()));
    }

    static void testCalendar() {
        System.out.println("----------------------------------testCalendar()");
        Date d1 = new Date(1000000000000L);
        System.out.println("1st date " + d1.toString());
        Calendar c = Calendar.getInstance();
        c.setTime(d1); // #1
        if(Calendar.SUNDAY == c.getFirstDayOfWeek()) {
            System.out.println("Sunday is the first day of the week");
        }

        if (Calendar.MONDAY==c.getFirstDayOfWeek()) {
            System.out.println("Monday is the first day of the week");
        }

        System.out.println("trillionth milli day of week is "
        + c.get(c.DAY_OF_WEEK)); // #3
        c.add(Calendar.MONTH, 1); // #4
        Date d2 = c.getTime(); // #5
        System.out.println("new date " + d2.toString() );
    }

    static void test() {
        Calendar cal=Calendar.getInstance();
        //cal.setTime(new Date);
        cal.add(Calendar.MONTH,-2);
        System.out.println("cal.getTime()"+cal.getTime());
    }
}
