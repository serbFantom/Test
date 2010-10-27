package com.serb.common_tutorial.obj_methods_test;

import java.awt.*;
import java.util.Arrays;

/**
 * User: S.Bezuglyi
 * Date: Aug 5, 2010
 * Time: 3:31:04 PM
 */
public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // !!!!!!! Broken - violates symmetry!
    /*@Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    } */

    //!!!!!!! Broken - violates transitivity!
    @Override
    public boolean equals(Object o) {
        //Arrays.equals()
        if (!(o instanceof Point))
            return false;
        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint))
            return o.equals(this);
        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("!!!!!!!!!!!!!!ColorPoint finalize() method hashCode= "+hashCode());
    }
}
