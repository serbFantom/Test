package com.serb.threads;

import java.util.*;
import java.util.concurrent.*;

/**
 * User: SBezugliy
 * Date: 04.02.2010
 */
enum Status {
    TypeA(0), TypeB(1);
    int id = 0;

    Status(int id) {
        this.id = id;
    }
}

public class ThreadsTest {
    static Status st = Status.TypeA;

    private Boolean equals(ThreadsTest t) {
        return true;
    }

    public class Inner {

    }

    public static class MyObject {
        private int i=5;

        public MyObject() {

        }

        public MyObject(int i) {
            this.i=i;
        }
        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    private static void myMethod(MyObject obj) {
        obj.setI(55);
        obj = new MyObject(50);
        obj.setI(150);
    }

    public static void main(String... args) throws Exception {
        /*MyObject obj = new MyObject(15);
        System.out.println("Before my method obj hash code and i field "+obj.hashCode()+","+obj.getI());
        myMethod(obj);
        System.out.println("After my method obj hash code and i field "+obj.hashCode()+","+obj.getI());

        List<String> strList = new ArrayList();
        Set<String> treeSet = new TreeSet(Collections.reverseOrder());
        treeSet.add(null);
        strList.add("4");
        strList.add("1");
        strList.add("3");
        strList.add("2");
        Collections.sort(strList);
        for (String str : strList) {
            System.out.print(str);
        }
        ThreadsTest ts = new ThreadsTest();

        Inner in2 = ts.new Inner();
        ts.getI(new Integer[1]);
        ts.getI(2L);
        //assert false:"Something wrong";
        System.out.println("Test run threads");
        System.out.println("Thread is " + Thread.currentThread().getName());
        System.out.printf("12%1$s", "13%1$s", "14%1$s");
        StringBuilder st = new StringBuilder("s");*/

        

        //testThreadInteraction2();

        //Uncomment if needed
        //testThreadInteraction();
        //testNamedList();
        //testSyncronize();
        //testDangerAccount();
        //testThreadExecutors(10);
        //testLiftOffThread(10);
        //testSimpleMultiplyThreads();


        /*List<Thread> threads = new ArrayList<Thread>();
        SerbThread1 serb1 = new SerbThread1();
        Thread th1 = new Thread(serb1);
        Thread th2 = new Thread(serb1);
        Thread th3 = new Thread(serb1);
        Thread th4 = new Thread(serb1);
        th4.interrupt();
        threads.add(th1);
        threads.add(th2);
        threads.add(th3);
        threads.add(th4);*/
        //testThreadPool(threads);
        ThreadsTest thTest=new ThreadsTest();
        //thTest.testInterruptThread();
        thTest.testThreadStop();

        //thTest.testDeadlock();

    }

    public void getI(Object i) {
        System.out.println("getI(int i)");
    }

    public void getI(int i) {
        System.out.println("getI(int i)");
    }

    public void getI(Integer... i) {
        System.out.println("getI(Integer... i)");
    }

    public void getI(Integer i) {
        System.out.println("getI(Integer i)");
    }

    @SuppressWarnings({"deprecation"})
    private void testThreadStop() throws Exception {
        ContinousThread continousThread=this.new ContinousThread();
        System.out.println("Start continousThread from main thread");
        continousThread.start();
        Thread.sleep(2500);
        continousThread.stop();
    }

    /**
     * Using manual mode for starting multiply threads, this is old style before java SE 5
     *
     * @throws Exception some exception
     */
    private static void testSimpleMultiplyThreads() throws Exception {
        System.out.println("--------testSimpleMultiplyThreads()---------");
        SerbThread2 serb2 = new SerbThread2();
        Thread one = new Thread(serb2);
        Thread two = new Thread(serb2);
        Thread three = new Thread(serb2);

        //set specific names for threads
        one.setName("Ivan");
        two.setName("Petro");
        three.setName("Sydor");
        //just for fun setting priority to threads
        one.setPriority(Thread.MIN_PRIORITY);
        two.setPriority(Thread.NORM_PRIORITY);
        three.setPriority(Thread.MAX_PRIORITY);
        //start our threads
        one.start();
        two.start();
        three.start();
        //cycle while our 3 threads are not terminated
        while (!one.getState().equals(Thread.State.TERMINATED) &&
                !two.getState().equals(Thread.State.TERMINATED) &&
                !three.getState().equals(Thread.State.TERMINATED)) {
            Thread.sleep(500);
            System.out.println("--------------one.getState().name()= " + one.getState().name());
            System.out.println("--------------two.getState().name()= " + two.getState().name());
            System.out.println("--------------three.getState().name()= " + three.getState().name());
        }
        System.out.println("--------------ALL HAS BEEN TERMINATED--------------------");
        //after threads terminated wait 1 sec
        Thread.sleep(1000);
        System.out.println("--------------one.getState().name()= " + one.getState().name());
        System.out.println("--------------two.getState().name()= " + two.getState().name());
        System.out.println("--------------three.getState().name()= " + three.getState().name());
    }

    /**
     * Using thread pool executor fro java.util.concurent for executing threads
     *
     * @param threads list of threads
     * @throws Exception exception during output states of threads
     */
    private static void testThreadPool(List<Thread> threads) throws Exception {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(512);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, queue);
        for (Thread th : threads) {
            threadPool.execute(th);
        }
        while (threadPool.getActiveCount() != 0) {
            Thread.sleep(2000);
            System.out.println("-------------------------------------------------------------------");
            for (Thread th : threads) {
                System.out.println("Thread start executed th.getState().name()= " + th.getState().name());
            }
        }
    }

    /**
     * Example from Bryce Ekkel Threads
     *
     * @param startCount numbers of threads that will be created during test
     */
    private static void testLiftOffThread(int startCount)  {
        System.out.println("------------------Test LiftOff Thread");
        System.out.println(startCount + " Threads will be created");
        for (int i = 0; i < startCount; i++) {
            Thread liftOffThread = new Thread(new ListOff());
            liftOffThread.start();
            //just for fun
            //The non-static join() method of class Thread lets one thread "join onto the end"
            //of another thread. If you have a thread B that can't do its work until another thread
            //A has completed its work, then you want thread B to "join" thread A. This means that
            //thread B will not become runnable until A has finished (and entered the dead state).
            //Join me (the current thread) to the end of t, so that t
            //must finish before the current thread(main in our case) can run again.
            //liftOffThread.join();
        }
        System.out.println("\n Thread " + Thread.currentThread().getName() + " wait for LiftOff Thread...");
    }

    private static void testThreadExecutors(int startCount) {
        System.out.println("------------------Test Thread Executors");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < startCount; i++) {
            exec.execute(new ListOff());
        }
        exec.shutdown();

    }


    /**
     * DeadLock generate!!!
     */
    private static void testSyncronize() {
        Queue<String> src = new PriorityQueue<String>();
        src.offer("First");
        src.offer("Second");
        src.offer("Third");

        Queue<String> dst = new PriorityQueue<String>();
        src.offer("First");
        src.offer("Second");
        src.offer("Third");
        Pipe pipe = new Pipe(src, dst);
        TestSyncronize testSynch = new TestSyncronize(pipe);
        testSynch.start();
        //Should lead to dead lock
        pipe.backward();
    }

    /**
     * Test dangerous of using not syncronizing methods
     */
    private static void testDangerAccount() {
        AccountDanger r = new AccountDanger();
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("Fred");
        two.setName("Lucy");
        one.start();
        two.start();
    }

    /**
     * Example of thread safety
     */
    private static void testNamedList() {
        final NameList nl = new NameList();
        nl.add("Ozymandias");
        class NameDropper extends Thread {
            public void run() {
                String name = nl.removeFirst();
                System.out.println(name);
            }
        }
        Thread t1 = new NameDropper();
        Thread t2 = new NameDropper();
        t1.start();        
        t2.start();
        
    }

    //TODO:this method callable description is in Bruce Ekkel book
    
    private static void testCallable() {
        //TaskWithResult
    }

    /**
     * three methods, wait(), notify(), and notifyAll()
     * must be called from within a synchronized
     * context! A thread can't invoke a wait or notify method on an object unless it owns
     * that object's lock
     */
    private static void testThreadInteraction() {
        Thread s1 = new Thread(new SerbThread1());

        synchronized (s1) {
            try {
                s1.wait();
                System.out.println("We are running...");
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Waiting for b to complete...");
    }

    /**
     * three methods, wait(), notify(), and notifyAll()
     * must be called from within a synchronized
     * context! A thread can't invoke a wait or notify method on an object unless it owns
     * that object's lock
     */
    private static void testThreadInteraction2() {
        Operator op = new Operator();
        Machine machine = new Machine(op);
        op.start();
        machine.start();
    }

    private void testInterruptThread() throws Exception {
        ContinousThread continousThread=this.new ContinousThread();
        System.out.println("Start continousThread from main thread");
        continousThread.start();
        Thread.sleep(10000);
        System.out.println("continousThread.interrupt() from main thread will be executed!!!");
        continousThread.interrupt();
        Thread.sleep(2000);
        System.out.println("Exit from main thread");
    }
    /**
     * Thread for showing example how to interrupt thread
     */
    public class ContinousThread extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    System.out.println("===ContinousThread working===");
                    if (this.isInterrupted()) {
                        System.out.println("!!!!Thread ContinousThread has recieve interrupt flag " +
                                "isInterrupted()==true. Will break thread");
                        break;
                    }
                } catch (InterruptedException e) {
                    System.out.println("!!!!Thread ContinousThread has recieve InterruptedException. Will break thread");
                    break;
                } finally {
                    System.out.println("*********Thread ContinousThread finally block");
                }
            }
            System.out.println("-----------------ContinousThread has finished it's work");
        }
    }

    /**
     * Shows how deadlock occured. Example from http://skipy.ru/technics/synchronization.html
     */
    private void testDeadlock() {
        System.out.println("----------------testDeadlock()");
        A a1 = new A();
        A a2 = new A();
        Thread t1 = new Thread(new Tester(a1,a2));
        Thread t2 = new Thread(new Tester(a2,a1));
        t1.start();
        t2.start();
    }

    /**
     * Simple thread realization for comparing two objects.
     */
    public static class Tester implements Runnable{

        static int nextId = 1;
        private A obj1;
        private A obj2;
        private int id = 0;

        public Tester(A obj1, A obj2){
            this.obj1 = obj1;
            this.obj2 = obj2;
            id = nextId++;
        }

        public void run(){
            print("Setting value to obj1... ");
            obj1.setValue(id);
            print("done.");
            print("Comparing objects... ");
            print("Done. Result: "+((obj1.equals(obj2)) ? "equal" : "not equal"));
        }

        private void print(String msg){
            System.out.println("Thread #"+id+": "+msg);
        }
    }

    /**
     * Simple data container used for showing how deadlock appeared
     */
    public static class A {

        private int value = 0;

        synchronized void setValue(int value){
            this.value = value;
        }

        synchronized int getValue(){
            return value;
        }

        public synchronized boolean equals(Object o){
            A a = (A) o;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                System.err.println("Interrupted!");
            }
            return value == a.getValue();
        }
    }

}