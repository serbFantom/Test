package com.serb.collection;

/**
 * User: SBezugliy
 * Date: 01.12.2009
 * Time: 15:03:44
 */
public class DVDInfo implements Comparable<DVDInfo> {
    String title;
    String genre;
    String leadActor;

    DVDInfo(String title, String genre, String leadActor) {
        this.title = title;
        this.genre = genre;
        this.leadActor = leadActor;
    }

    public String toString() {
        return title + " " + genre + " " + leadActor + "\n";
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int compareTo(DVDInfo o) {
        return title.compareTo(o.getTitle());
    }
}
