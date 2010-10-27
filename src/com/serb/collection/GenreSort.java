package com.serb.collection;

import java.util.Comparator;

/**
 * User: SBezugliy
 * Date: 01.12.2009
 */
public class GenreSort implements Comparator<DVDInfo> {

    public int compare(DVDInfo di1, DVDInfo di2) {
        //use String compareTo method
        return di1.getGenre().compareTo(di2.getGenre());
    }
}
