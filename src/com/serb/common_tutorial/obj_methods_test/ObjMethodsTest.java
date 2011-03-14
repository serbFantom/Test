package com.serb.common_tutorial.obj_methods_test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * User: S.Bezuglyi
 * Date: Aug 5, 2010
 * Time: 3:33:02 PM
 */
public class ObjMethodsTest {


    static {
        N = 1; // почему тут не ошибка?
        //System.out.println(N); //тут ошибка
    }
    private static final int N;

    public static void main(String[] args) throws Exception {
        //test symmetry
        /*Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println("----------------------Test symmetry----------------------");
        System.out.println("p.equals(cp)= "+p.equals(cp));
        System.out.println("cp.equals(p)= "+cp.equals(p));
        System.out.println("----------------------End test symmetry----------------------");
        //test transitivity
        {
            {
                ColorPoint colPoint=new ColorPoint(2, 2, Color.BLACK);
                System.out.println("colPoint.hashCode()= "+colPoint.hashCode());
            }
        } 
        Thread.sleep(5000);
        Thread th=new Thread( new Runnable() {
            public void run() {
                ColorPoint colPoint234=new ColorPoint(2, 2, Color.BLACK);
                System.out.println("colPoint234.hashCode()= "+colPoint234.hashCode());
                int i=colPoint234.hashCode();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        System.gc();
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println("----------------------Test transitivity----------------------");
        System.out.println("p1.equals(p2)= "+p1.equals(p2));
        System.out.println("p2.equals(p3)= "+p2.equals(p3));
        System.out.println("p1.equals(p3)= "+p1.equals(p3));
        System.out.println("----------------------END test transitivity----------------------");*/

        System.out.println("----------------------Test equals without overriding hashCode()----------------------");

        HashMap<Point,String> mapPoint=new HashMap<Point,String>();
        List<Point> listPoint=new ArrayList<Point>();
        listPoint.add(new Point(2,2));
        mapPoint.put(new Point(1, 2), "point (1,2)");
        

        System.out.println("mapPoint.get(new Point(1,2))= "+mapPoint.get(new Point(1,2)));
        System.out.println("listPoint.contains(new Point(2,2))= "+listPoint.contains(new Point(2,2)));
        System.out.println("----------------------END test equals without overriding hashCode()----------------------");
    }
}
