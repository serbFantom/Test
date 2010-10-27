package com.serb.flow_control;

/**
 * User: SBezugliy
 * Date: 24.03.2009 15:35:33
 */
public class AssertionsTest {
    public static void main (String args[]) {
        test();
    }

    /**
     * Simply show how to use assertions in java code
     * for enabling assertions use -ea flag for virtual machine
     * bu default assertion disabled
     * for disabling -da
     * Yo can anable/disable for somne poackage or class, e.g. java -ea:com.foo
     */
    public static void test() {
        System.out.println("---------------------------------");
        System.out.println("Assertions test");
        System.out.println("---------------------------------");
        /*Do Use Assertions, Even in Public Methods, to Check for Cases
        that You Know Are Never, Ever Supposed to Happen
        This can include code blocks that should never be reached, including the default of
        a switch statement as follows:*/
        int x=100;
        int y=0;
        switch(x) {
            case 1: y = 3;
            case 2: y = 9;
            case 3: y = 27;
            default: assert false:"x equal="+x; // We're never supposed to get here!
        }
        int num=0;
        assert(num == 3):"Num not equals 3";

    }
}
