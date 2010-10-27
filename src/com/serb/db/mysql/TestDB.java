package com.serb.db.mysql;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 28.05.2009
 * Time: 10:35:48
 */
public class TestDB {

    public static void main(String[] args) throws InterruptedException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //conn = DriverManager.getConnection("jdbc:mysql://inode-07/npm1?user=serb");
            conn = DriverManager.getConnection("jdbc:mysql://10.4.32.19/npm1?user=serb");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();            
            //rs = stmt.executeQuery("SELECT CODE,NAME FROM customer_test;");
            /*if (rs.first()) {
                System.out.println("rs.getString(1)= "+rs.getString(1));
                System.out.println("rs.getString(2)= "+rs.getString(2));
            }*/
            System.out.println("*********************************************");
            System.out.println("****************Used for testing replication in stand by mode****************");
            System.out.println("*********************************************");
            System.out.println("Insert values into customer_test every 5 sec");
            while (true) {
                //insert values                                
                System.out.println("----------------------------------------------------------");
                System.out.println("INSERT INTO customer_test (NAME) values ('Test SergeyB');");
                stmt.executeUpdate("INSERT INTO customer_test (NAME) values ('Test SergeyB');");
                stmt.executeUpdate("commit");
                System.out.println("----------------------------------------------------------");
                Thread.sleep(5000);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }

    }
}
