package com.serb.collection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: SBezugliy
 * Date: 01.12.2009
 */
public class SearchObjArray {
    private static Logger log = Logger.getLogger(SearchObjArray.class.getName());

    static {
        PropertyConfigurator.configure("./conf/logging.properties");        
    }

    protected void search() {
        String[] sa = {"one", "two", "three", "four"};
        log.info("\n Initial one = "
                + Arrays.binarySearch(sa, "one"));
        log.info("\n Initial three = "
                + Arrays.binarySearch(sa, "three"));

        Arrays.sort(sa); // #1
        for (String s : sa)
            log.info(s + " ");
        //Search for the location of element "one", which is 1.
        log.info("\none = "
                + Arrays.binarySearch(sa, "one")); // #2
        log.info("\n Sorted three three = "
                + Arrays.binarySearch(sa, "three"));
        log.info("\n Sorted  unknown = "
                + Arrays.binarySearch(sa, "unknown"));
        log.info("now reverse sort");
        /*Make a Comparator instance. On the next line we re-sort the array using
        the Comparator.*/
        ReSortComparator rs = new ReSortComparator(); // #3
        Arrays.sort(sa, rs);
        for (String s : sa)
            log.info(s + " ");
        /*
        Attempt to search the array. We didn't pass the binarySearch()
        method the Comparator we used to sort the array, so we got an incorrect
        (undefined) answer.
         */
        log.info("\none = "
                + Arrays.binarySearch(sa, "one")); // #4
        log.info("one = "
                + Arrays.binarySearch(sa, "one", rs));
    }

    /**
     * Define the Comparator; it's okay for this to be an inner class.
     */
    static class ReSortComparator implements Comparator<String> {
        public int compare(String a, String b) {
            //By switching the use of the arguments in the invocation of compareTo(), we get an inverted sort.
            return b.compareTo(a); 
        }
    }

}
