package com.serb.common_tutorial.obj_methods_test;

/**
 * User: S.Bezuglyi
 * Date: Aug 5, 2010
 * Time: 3:06:20 PM
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    /*@Override
    public int hashCode() {
        return 30;
    } */
}
