package com.serb.flow_control;

/**
 * User: sbezugliy
 * Date: 12.02.2009 11:50:11
 */
public class MyException extends Exception {



    public static void main(String[] args) throws Exception{
        
        if (args.length>0) {
            MyException myEx=new MyException();

            myEx.parseInt(args[1]);
            try {
                myEx.checkFood(args[0]);
            }
            catch (ClassCastException ex) {
                //
            }
            catch (BadFoodException ex) {
                ex.printStackTrace();
            }
        }



    } 

    public String checkFood(String food) throws BadFoodException {
        if (food!=null) {
            throw new BadFoodException();
        }
        return food;
    }

    int parseInt(String s) throws NumberFormatException {
        boolean parseSuccess = false;
        int result = 0;
        // do complicated parsing
        result=Integer.parseInt(s);
        /*parseSuccess=
        if (!parseSuccess) // if the parsing failed
            throw new NumberFormatException();*/
        methodA(result);
        return result;
    }

    private void methodA(int num) {
        assert(num < 0);
        /*if (num >= 0) {
           // useNum(num + x);
        } else { // num must be < 0
        // This code should never be reached!
            System.out.println("Yikes! num is a negative number! "
                    + num);
        } */
    }
}
