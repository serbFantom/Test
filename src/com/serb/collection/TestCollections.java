package com.serb.collection;

import com.serb.serialization.Dog;
//import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.*;

import java.text.ParseException;


/**
 * Created by SBezugliy
 * Date: 15.09.2009
 */

public class TestCollections {
    
    private static Logger log = Logger.getLogger(TestCollections.class.getName());
    private static Random randomGenerator;

    static {
        PropertyConfigurator.configure("./conf/logging.properties");
        randomGenerator = new Random();
    }

    enum Pets {
        DOG, CAT, HORSE
    }



    static class PQsort implements Comparator<Integer> { // inverse sort

        public int compare(Integer one, Integer two) {
            return two - one; // unboxing
        }
    }

    public static void main(String[] args) throws ParseException {
        //testList();
        //testSets();
        //testMaps();
        /*
        testQueue();
        testMaps();
        testComparator();
        testDVDInfo();*/
        //testSearchObjArray();
        //arraysToListTest();
        /*arraysToListTest();
        listToArrays();*/
        //testLazyCollections();
        //testQueue();
        //Map m = new HashMap();
        //Map<Object, Object> m = new TreeMap<Object, Object>();
        //Map<Object, ?> m = new LinkedHashMap<Object, Object>();
        //m.put(1, new Object()); 	//2
        //m.put(1.0, "Hello");  	//3
        //testEqualsAndHashCode();
        //testSetsOrder();
        //testListOrder();
        //testTypesForArrayList();
        //testMapOrder();

        //testMapOrder();
        //testSetOperations();
        testTypesForMaps();

    }

    /**
     * Lists of things (classes that implement List).
     * A List cares about the index. The one thing that List has that non-lists don't have
     * is a set of methods related to the index. Those key methods include things like
     * get(int index), indexOf(Object o), add(int index, Object obj)
     */
    private static void testList() {
        log.info("-------START testList()----------");
        List<String> tstListSrc = new ArrayList<String>();

        tstListSrc.add("1");
        tstListSrc.add("2");
        tstListSrc.add("3");
        tstListSrc.add("4");
        tstListSrc.add("5");
        tstListSrc.add("6");
        tstListSrc.add("7");
        tstListSrc.add(5, "999");
        List<String> tstListDist = new ArrayList<String>();

        for (String listElem : tstListSrc) {
            if (listElem.equals("6")) {
                tstListDist.clear();
                tstListDist.add(listElem);
                break;
            }
            tstListDist.add(listElem);
            log.info("listElem= " + listElem);
        }
        //
        List<Dog> d = new ArrayList<Dog>();
        Dog dog = new Dog("aiko");
        d.add(dog);
        d.add(new Dog("clover"));
        d.add(new Dog("magnolia"));
        Iterator<Dog> i3 = d.iterator(); // make an iterator
        while (i3.hasNext()) {
            Dog d2 = i3.next(); // cast not required
            log.info(d2.name);
        }
        /*The rest of the code demonstrates using the size(), get(), indexOf(), and
        toArray() methods*/
        log.info("size " + d.size());
        log.info("get1 " + d.get(1).name);
        log.info("aiko " + d.indexOf(dog));
        d.remove(2);
        Object[] oa = d.toArray();
        for (Object o : oa) {
            Dog d2 = (Dog) o;
            log.info("oa " + d2.name);
        }
        log.info("-------START testList()----------");
    }

    /**
     * Unique things (classes that implement Set).
     */
    private static void testSets() {
        log.info("-------START testSets()----------");
        Set testSet = new HashSet();
        Object obj = new Object();
        log.info("testSet.add(\"1\")" + testSet.add("1"));
        log.info("testSet.add(\"1\")" + testSet.add("1"));
        log.info("testSet.add(\"1\")" + testSet.add("1"));
        log.info("testSet.add(\"2\")" + testSet.add("2"));
        log.info("testSet.add(\"3\")" + testSet.add("3"));

        //
        boolean[] ba = new boolean[5];
        //Set s = new TreeSet(); //wiil be ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        Set s = new HashSet();
        ba[0] = s.add("a");
        ba[1] = s.add(new Integer(42));
        ba[2] = s.add("b");
        ba[3] = s.add("a");
        ba[4] = s.add(new Object());
        for (int x = 0; x < ba.length; x++)
            log.info(ba[x] + " ");
        log.info("\n");
        for (Object o : s)
            log.info(o + " ");
        log.info("-------END testSets()----------");
    }

    /**
     * Things arranged by the order in which they are to be processed.
     * Using the PriorityQueue Class
     */
    private static void testQueue() {
        log.info("-------START testQueue()----------");

        int[] ia = {1, 5, 3, 7, 6, 9, 8}; // unordered data
        System.out.println("*****************************");
        System.out.println("pq1 queue used Used natural order (by default)");
        System.out.println("*****************************");
        PriorityQueue<Integer> pq1 =
                new PriorityQueue<Integer>(); // use natural order

        System.out.println("pq1 fill using offer method");
        for (int x : ia) // load queue
            pq1.offer(x);
        for (int x : ia) // review queue
            System.out.print(pq1.poll() + " ");

        System.out.println("\n pq1 fill using add method");
        for (int x : ia) // load queue
            pq1.add(x);
        for (int x : ia) // review queue
            System.out.print(pq1.poll() + " ");
        System.out.println("");
        PQsort pqs = new PQsort(); // get a Comparator
        PriorityQueue<Integer> pq2 =
                new PriorityQueue<Integer>(10, pqs); // use Comparator

        System.out.println("*****************************");
        System.out.println("pq2 queue with PQsort used");
        System.out.println("*****************************");

        System.out.println("\n pq2 fill using offer method");
        for (int x : ia) // load queue
            pq2.offer(x);
        System.out.println("size " + pq2.size());
        System.out.println("peek " + pq2.peek());
        System.out.println("size " + pq2.size());
        System.out.println("poll " + pq2.poll());
        System.out.println("size " + pq2.size());
        for (int x : ia) // review queue
            System.out.print(pq2.poll() + " ");

        System.out.println("\n pq2 fill using add method");
        for (int x : ia) // load queue
            pq2.add(x);
        System.out.println("size " + pq2.size());
        System.out.println("peek " + pq2.peek());
        System.out.println("size " + pq2.size());
        System.out.println("poll " + pq2.poll());
        System.out.println("size " + pq2.size());
        for (int x : ia) { // review queue
            //This method differs from poll only in that it throws an exception if this queue is empty.
            //System.out.print(pq2.remove() + " ");
            System.out.print(pq2.poll() + " ");
        }


        System.out.println("\n *****************************");
        System.out.println("pq3 queue natural ordering");
        System.out.println("*****************************");
        String[] sa = {">ff<", "> f<", ">f <", ">FF<"}; // ordered?
        PriorityQueue<String> pq3 = new PriorityQueue<String>();
        for (String s : sa) {
            pq3.offer(s);
        }

        for (String s : sa) {
            System.out.println(pq3.poll() + " ");
        }

        System.out.println("");
        log.info("-------END testQueue()----------");
    }

    /**
     * Things with a unique ID (classes that implement Map).
     */
    private static void testMaps() {
        log.info("-------START testMaps()----------");
        HashMap testMap = new HashMap();
        //If the map previously contained a mapping for the key, the old value is replaced.
        //he previous value associated with key, or null if there was no mapping for key.
        // (A null return can also indicate that the map previously associated null with key.)
        log.info("testMap.put(\"1\",\"1\")= " + testMap.put("1", "1"));
        log.info("testMap.put(\"1\",\"2\")= " + testMap.put("1", "2"));
        log.info("testMap.put(\"1\",\"3\")= " + testMap.put("1", "3"));
        log.info("testMap.put(\"1\",\"4\")= " + testMap.put("1", "4"));
        log.info("testMap.put(\"2\",\"1\")= " + testMap.put("2", "1"));

        //Tree map
        /*TreeMap<Object, Object> testTreeMap = new TreeMap();
        Object obj = new Object();
        Object obj2 = new Object();
        testTreeMap.put(obj, obj);
        testTreeMap.put(obj2, obj2);*/

        /*
        it's legal to use a class that doesn't override equals()
        and hashCode() as a key in a Map; your code will compile and run, you just won't
        find your stuff.) Here's some code demonstrating the use of a HashMap
        */
        Map<Object, Object> m = new HashMap<Object, Object>();
        m.put("k1", new Dog("aiko")); // add some key/value pairs
        m.put("k2", Pets.DOG);
        m.put(Pets.CAT, "CAT key");
        Dog d1 = new Dog("clover"); // let's keep this reference

        m.put(d1, "Dog key");
        m.put(new Cat(), "Cat key");
        m.put(new Cat("Vaska", 2), "Cat(\"Vaska\",2) key");

        System.out.println(m.get("k1")); // #1
        String k2 = "k2";
        System.out.println(m.get(k2)); // #2
        Pets p = Pets.CAT;

        System.out.println("m.get(p)= " + m.get(p)); // #3
        System.out.println("m.get(d1)= " + m.get(d1)); // #4
        //Cat uses HashCodeBuilder and EqualsBuilder in hashCode() and equals() methods
        System.out.println("m.get(new Cat())= " + m.get(new Cat())); // #5
        System.out.println(m.size()); // #6
        System.out.println("m.get(new Cat(\"Vaska\",2))= " + m.get(new Cat("Vaska", 2)));

        log.info("-------END testMaps()----------");

    }

    /**
     * Simple test of Comparator and Collections.sort
     */
    private static void testComparator() {
        List<String> tstListInitial = new ArrayList<String>();
        tstListInitial.add("1");
        tstListInitial.add("7");
        tstListInitial.add("2");
        tstListInitial.add("4");
        tstListInitial.add("3");
        tstListInitial.add("6");
        tstListInitial.add("5");
        log.info("tstListInitial created: \n" + tstListInitial);
        Collections.sort(tstListInitial);
        log.info("After Collections.sort tstListInitial: \n" + tstListInitial);
    }

    /**
     * Test DVDInfo list sorting and other
     */
    private static void testDVDInfo() {
        log.info("-------START testDVDInfo()----------");
        List<DVDInfo> dvdInfo = generateRandomDVDInfoList(10);
        log.info("dvdInfo created: \n" + dvdInfo);
        Collections.sort(dvdInfo, new GenreSort());
        log.info("dvdInfo sorted using GenreSort Comparator: \n" + dvdInfo);
        Collections.sort(dvdInfo);
        log.info("dvdInfo sorted using Comparable by title: \n" + dvdInfo);
        log.info("-------END testDVDInfo()----------");
    }

    /**
     * Generate random DVDInfo list
     *
     * @param size size of list
     * @return generated list
     */
    private static List<DVDInfo> generateRandomDVDInfoList(int size) {
        List<DVDInfo> dvdInfoLst = new ArrayList<DVDInfo>();
        for (int i = 0; i < size; i++) {
            dvdInfoLst.add(new DVDInfo(getRandomString(3), getRandomGenre(), getRandomString(3)));
        }
        return dvdInfoLst;
    }

    /**
     * A simple random String generator, user can specify the length.
     * Default length is 8, the common unix system effective password length.
     * <p/>
     * Can be used as password generator (http://bobcat.webappcabaret.net/javachina/jc/share/PwGen.htm)
     *
     * @param n length
     * @return random String
     */
    public static String getRandomString(int n) {
        char[] pw = new char[n];
        int c = 'A';
        int r1;
        for (int i = 0; i < n; i++) {
            r1 = (int) (Math.random() * 3);
            switch (r1) {
                case 0:
                    c = '0' + (int) (Math.random() * 10);
                    break;
                case 1:
                    c = 'a' + (int) (Math.random() * 26);
                    break;
                case 2:
                    c = 'A' + (int) (Math.random() * 26);
                    break;
            }
            pw[i] = (char) c;
        }
        return new String(pw);
    }

    private static String getRandomGenre() {
        String[] genre = {"Animation", "Comedy", "Horror", "Musicals", "Romance", "Western"};
        //the same as randomGenerator.nextInt(genre.length)
        int i = (int) (Math.random() * genre.length);
        return genre[i];
    }

    private static void testSearchObjArray() {
        log.info("-------START testSearchObjArray()----------");

        SearchObjArray objArray = new SearchObjArray();
        objArray.search();
        log.info("-------END testSearchObjArray()----------");
    }

    /**
     * The Arrays.asList() method copies an array into a List. The API says,
     * "Returns a fixed-size list backed by the specified array. (Changes to the returned list
     * 'write through' to the array.)" When you use the asList() method, the array and
     * the List become joined at the hip.
     * <p/>
     * When you update one of them, the other gets
     * updated automatically!
     */
    private static void arraysToListTest() {
        log.info("-------START arraysToListTest()----------");
        String[] sa = {"one", "two", "three", "four"};
        List sList = Arrays.asList(sa); // make a List
        log.info("List created from array sList= " + sList);
        sa[0] = "ChangedValue";
        //log.info("size " + sList.size());
        //log.info("idx2 " + sList.get(2));
        log.info("List after modifying array sList= " + sList);

        sList.set(3, "six"); // change List
        sa[1] = "five"; // change array
        for (String s : sa) {
            log.info(s + " ");
        }
        log.info("\nsl[1] " + sList.get(1));

        log.info("-------END arraysToListTest()----------");
    }

    private static void listToArrays() {
        log.info("-------START listToArrays()----------");
        List<Integer> iL = new ArrayList<Integer>();
        for (int x = 0; x < 3; x++) {
            iL.add(x);
        }
        log.info("List created and filled iL= " + iL);
        Object[] oa = iL.toArray(); // create an Object array
        Integer[] ia2 = new Integer[3];
        ia2 = iL.toArray(ia2); // create an Integer array
        oa[0] = 3;
        //ia2[1]=345;
        log.info("After modify of the arrays iL= " + iL);
        iL.set(0, 345);
        for (Integer i : ia2) {
            log.info(i + " ");
        }
        log.info("-------END listToArrays()----------");
    }

    /**
     *
     */
    private static void testLazyCollections() {
        log.info("-------START testLazyCollections()----------");
        log.info("**********************************");
        log.info("Using Usual Methods");
        log.info("**********************************");
        List<Long> profits = new ArrayList<Long>();
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Ivan", "Ivanov", 22, 1, Employee.Gender.MALE));
        employees.add(new Employee("Sydor", "Sydorov", 25, 2, Employee.Gender.MALE));
        employees.add(new Employee("Petro", "Petrov", 33, 5, Employee.Gender.MALE));
        employees.add(new Employee("Alexander", "Petrenko", 35, 7, Employee.Gender.MALE));

        for (Employee empl : employees) {
            if (empl != null && empl.getAge() >= 18 && empl.getAge() < 27
                    && Employee.Gender.MALE.equals(empl.getGender()))
                profits.add(empl.getProfit());
        }

        for (Long pr : profits)
            System.out.println("Profit: " + pr);

        log.info("**********************************");
        log.info("Using Lazy Collections");
        log.info("**********************************");
        profits = CollectionsUtils.transform(
                CollectionsUtils.filter(
                        CollectionsUtils.filter(
                                CollectionsUtils.trim(employees),
                                new IPredicate<Employee>() {
                                    public boolean apply(Employee input) {
                                        return Employee.Gender.MALE.equals(input.getGender());
                                    }
                                }),
                        new IPredicate<Employee>() {
                            public boolean apply(Employee input) {
                                return input.getAge() >= 18 && input.getAge() < 27;
                            }
                        }),
                new IFunction<Employee, Long>() {
                    public Long apply(Employee input) {
                        return input.getProfit();
                    }
                });

        for (Long pr : profits)
            System.out.println("Profit: " + pr);
        log.info("-------END testLazyCollections()----------");
    }

    static void testEqualsAndHashCode() {
        log.info("-------START testEqualsAndHashCode()----------");
        Cat cat1=new Cat("Amy",10);
        Cat cat2=new Cat("Amy",10);
        log.info("cat1.equals(cat2)= "+cat1.equals(cat2));
        log.info("cat2.equals(cat2)= "+cat2.equals(cat2));
        log.info("cat2.equals(cat1)= "+cat2.equals(cat1));
        log.info("cat1.hashCode()= "+cat1.hashCode());
        log.info("cat2.hashCode()= "+cat2.hashCode());
        Cat cat3=new Cat("Uria",15);
        log.info("cat3.equals(cat1)= "+cat3.equals(cat1));
        log.info("cat3.hashCode()= "+cat3.hashCode());
        log.info("-------END testEqualsAndHashCode()----------");
    }

    static void testSetsOrder() {
        Set<String> orderedSet = new LinkedHashSet<String>();

        orderedSet.add("1");
        orderedSet.add("2");
        orderedSet.add("3");
        orderedSet.add("4");
        orderedSet.add("5");
        orderedSet.add("6");
        orderedSet.add("7");
        orderedSet.add("8");
        orderedSet.add("9");
        orderedSet.add("10");
        System.out.println("LinkedHashSet test");
        for (String value : orderedSet)
            System.out.println(value);


        Set<String> notOrderedSet = new HashSet<String>();

        notOrderedSet.add("1");
        notOrderedSet.add("2");
        notOrderedSet.add("3");
        notOrderedSet.add("4");
        notOrderedSet.add("5");
        notOrderedSet.add("6");
        notOrderedSet.add("7");
        notOrderedSet.add("8");
        notOrderedSet.add("9");
        notOrderedSet.add("10");
        System.out.println("HashSet test");
        for (String value : notOrderedSet)
            System.out.println(value);

        Set<String> sortedSet = new TreeSet<String>();

        sortedSet.add("9");
        sortedSet.add("7");
        sortedSet.add("1");
        sortedSet.add("2");
        sortedSet.add("8");
        sortedSet.add("3");
        sortedSet.add("4");
        sortedSet.add("5");
        sortedSet.add("6");




        System.out.println("TreeSet test");
        for (String value : sortedSet)
            System.out.println(value);
    }

    static void testListOrder() {
        
        List<String> arrayList = new ArrayList<String>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

        List<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("01");
        arrayList2.add("02");
        arrayList.addAll(3, arrayList2);

        System.out.println("ArrayList test");
        for (String value : arrayList)
            System.out.println(value);


        //Set<String> notOrderedSet = new HashSet<String>();
        List<Object> linkedList = new LinkedList<Object>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("10");
        System.out.println("LinkedList test");
        printContainer(linkedList.iterator());
        /*for (String value : linkedList)
            System.out.println(value);*/

    }

    static void testTypesForArrayList() {
        List list=new LinkedList();
        
        list.add(new Employee());
        list.add(new Cat());
        Collections.addAll(list,1,2,4);
        for(Object obj:list) {
            System.out.println(obj);
        }
    }


     static void testMapOrder() {         
         //Test not ordered Map->HashMap
         Map<Object,Object> notOrderedMap=new HashMap<Object,Object>();
         notOrderedMap.put("1","First");
         notOrderedMap.put("2","Second");
         notOrderedMap.put("3","Third");
         notOrderedMap.put("4","Fourth");
         notOrderedMap.put(new Cat(),"Five");
         System.out.println("HashMap test");
         printContainer(notOrderedMap.values().iterator());
         /*for (Object value:notOrderedMap.values()) {
             System.out.println(value);
         } */
         //Test ordered Map->LinkedHashMap
         Map<Object,Object> orderedMap=new LinkedHashMap<Object,Object>();
         orderedMap.put("4","Fourth");
         orderedMap.put("1","First");
         orderedMap.put("2","Second");
         orderedMap.put("3","Third");
         orderedMap.put(new Cat(),"Five");

         System.out.println("LinkedHashMap test");
         printContainer(orderedMap.values().iterator());
         /*for (Object value:orderedMap.values()) {
             System.out.println(value);
         } */

         //Test sorted by keys Map->TreeHashMap
         Map<Object,Object> sortedMap=new TreeMap<Object,Object>();

         sortedMap.put("1","First");
         sortedMap.put("4","Fourth");
         sortedMap.put("3","Third");
         sortedMap.put("2","Second");

         //sortedMap.put(new Cat(),"Five"); //this will be exception in runtime 


         System.out.println("LinkedHashMap test");
         printContainer(sortedMap.values().iterator());
         /*for (Object value:sortedMap.values()) {
             System.out.println(value);
         } */
     }

    /**
     * For show how can Iterator work
     * @param it iterator of Collection
     */
    static void printContainer(Iterator<Object> it) {
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    static void testTypesForMaps() {
        Random rand=new Random(47);
        Map<Integer,Integer> intMap=new HashMap<Integer,Integer>();
        for (int i=0;i<10000;i++) {
            //get random integer from 0 to 20
            int r=rand.nextInt(20);
            Integer freq=intMap.get(r);
            intMap.put(r,freq==null?1:freq+1);
        }
        System.out.println(intMap);
    }

    /**
     * Show main operations with Set's
     * Use TreeSet for comfortable view
     */
    static void testSetOperations() {
        Set<String> setStr1=new TreeSet<String>();
        Collections.addAll(setStr1,"A B C D E F G H I J K L".split(" "));
        setStr1.add("M");
        System.out.println("H "+setStr1.contains("H"));
        System.out.println("N "+setStr1.contains("N"));

        Set<String> setStr2=new TreeSet<String>();
        Collections.addAll(setStr2,"H I J K L".split(" "));
        System.out.println("setStr2 in setStr1 "+setStr1.containsAll(setStr2));
        setStr2.remove("H");
        System.out.println("setStr1= "+setStr1);
        System.out.println("setStr2 in setStr1 "+setStr1.containsAll(setStr2));
        setStr1.removeAll(setStr2);
        System.out.println("setStr2 removed from setStr1");
        System.out.println("setStr1= "+setStr1);
        Collections.addAll(setStr1,"X Y Z".split(" "));
        System.out.println("X Y Z was added to setStr1");
        System.out.println("setStr1= "+setStr1);
    }

    static void testQueuesOperations() {
        
    }

}
