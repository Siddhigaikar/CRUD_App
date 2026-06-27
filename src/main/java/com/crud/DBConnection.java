package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/crud_app",
                "root",
                "roots@20"
            );

            System.out.println("Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }

        return con;
    }
}