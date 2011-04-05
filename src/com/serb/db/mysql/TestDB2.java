package com.serb.db.mysql;

import java.sql.*;

/**
 * User: S.Bezuglyi
 * Date: Apr 5, 2011
 */
public class TestDB2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contactmanager",
                "contactmanager", "1234");
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID,FIRSTNAME FROM CONTACTS");
        while (rs.next()) {
            System.out.println("ID: "+rs.getObject(1));
            System.out.println("FIRSTNAME: "+rs.getObject(2));
            System.out.println("---------------------------------------");
        }
    }
}
