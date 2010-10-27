package com.serb.flow_control;

/**
 *
 * User: SBezugliy
 * Date: 09.02.2009 17:52:08
 */
public class FlowControlTest {

    static final Number const1=1;
    static final Number const2=1;
    static final Number const3=1;

    public static void main(String[] args) {
        int price = 1000;
        if (price < 300) {
            buyProduct();
        } else {
            if (price < 400) {
                getApproval();
            } else {
                dontBuyProduct();
            }
        }
        Integer x = 2;


        switch (x) {
            case 1:
                System.out.println("x is equal to 1");
                break;
            case 2:
                System.out.println("x is equal to 2");
                break;
            case 3:
                System.out.println("x is equal to 3");
                break;
            default:
                System.out.println("Still no idea what x is");
        }

        byte g = 2;
        switch (g) {
            case 2:
            case 23:
        }


        int x1 = 4;
        switch (x1) {
            case 2:
            case 4:
            case 6:
            case 8:
            case 10: {
                System.out.println("x1 is an even number"); break;
            }
            default: System.out.println("x is an odd number");
        }

        char ch='c';
        switch (ch) {
            case 'a': {
                System.out.println("This is char a!");
                break;
            }
            case 'b': {
                System.out.println("This is char b!");
                break;
            }
            default: {
                System.out.println("Unkown for this statement char!");
            }
        }




        //FlowControlEnumTest.BIG=new FlowControlEnumTest();
    }

    static private void buyProduct() {

    }


    static private void getApproval() {

    }

    static private void dontBuyProduct() {

    }

}
