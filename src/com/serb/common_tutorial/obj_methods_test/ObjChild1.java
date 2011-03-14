package com.serb.common_tutorial.obj_methods_test;

import com.serb.common_tutorial.Dog3;

/**
 * .
 * User: S.Bezuglyi
 * Date: Aug 5, 2010
 */
public class ObjChild1 {

    @Override
    public boolean equals(Object obj) {
       
        return this==obj;
    }

    public static void main(String[] args) {
        ObjChild1 objChild=new ObjChild1();
        objChild.hashCode();
    }
}
