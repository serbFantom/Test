package com.serb.threads;

/**
 * The Runnable object holds a reference to a single account.
    2. Two threads are started, representing Lucy and Fred, and each thread is
    given a reference to the same Runnable (which holds a reference to the
    actual account)
    3. The initial balance on the account is 50, and each withdrawal is exactly 10.
    4. In the run() method, we loop 5 times, and in each loop we
    n Make a withdrawal (if there's enough in the account).
    n Print a statement if the account is overdrawn (which it should never be,
    since we check the balance before making a withdrawal).
    5. The makeWithdrawal() method in the test class (representing the behavior
    of Fred or Lucy) will do the following:
    n Check the balance to see if there's enough for the withdrawal.
    n If there is enough, print out the name of the one making the withdrawal.
    n Go to sleep for 500 milliseconds�just long enough to give the other
    partner a chance to get in before you actually make the withdrawal.
    n Upon waking up, complete the withdrawal and print that fact.
    n If there wasn't enough in the first place, print a statement showing who you
    are and the fact that there wasn't enough.

 * User: SBezugliy
 * Date: 11.02.2010
 */
public class AccountDanger implements Runnable {
    private Account acct = new Account();

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }
    
    private synchronized void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName()
                    + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            acct.withdraw(amt);
            System.out.println(Thread.currentThread().getName()
                    + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw " + acct.getBalance());
        }
    }
}
