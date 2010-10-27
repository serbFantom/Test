package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class AccountTestThread implements Runnable {
    private Account account;

    public AccountTestThread(Account account) {
        this.account=account;
    }

    public void run() {
        System.out.println("AccountTestThread run by "+Thread.currentThread().getName());
        account.withdraw(10);
    }
}
