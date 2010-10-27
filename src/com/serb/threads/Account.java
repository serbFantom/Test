package com.serb.threads;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    /**
     * Take money
     * @param amount amount that we want to take
     */
    public void withdraw(int amount) {
        balance = balance - amount;
    }
}
