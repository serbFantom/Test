package com.serb.collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * User: SBezugliy
 * Date: 02.12.2009
 */
public class Cat implements Comparable<Cat>{
    public String name;
    public int catSize;
    public static final String DEFAULT_CAT_NAME = "Murka";
    public static final int DEFAULT_CAT_SIZE = 1;

    public Cat() {
        name = DEFAULT_CAT_NAME;
        catSize = DEFAULT_CAT_SIZE;
    }

    public Cat(String name, int catSize) {
        this.name = name;
        this.catSize = catSize;
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Cat && this.equals((Cat) obj);
    }

    public boolean equals(Cat that) {
        return this == that || new EqualsBuilder().
                append(this.name, that.name).
                append(this.catSize, that.catSize).
                isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().
                append(name).
                append(catSize).
                toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).
                append("Name", name).
                append("Cat size", catSize).
                toString();
    }


   /* public int compareTo(Object o) {
        //todo:implement this method        
        return 0;
    }*/

    public int compareTo(Cat o) {
        return 0;  
    }
}
