package com.db_conexioa;

import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa {
    static final String DB_URL = "jdbc:mysql://localhost:3306/froga";
    static final String USER = "root";
    static final String PASS = "mysql";

    public void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                System.out.println("Ondo konektatu da");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
