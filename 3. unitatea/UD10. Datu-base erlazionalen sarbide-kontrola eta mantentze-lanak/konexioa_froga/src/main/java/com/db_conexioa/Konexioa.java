package com.db_conexioa;

import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa {
    static final String db_url = "jdbc:mysql://localhost:3306/froga";
    static final String erabiltzailea = "root";
    static final String pasahitza = "mysql";

    public void konektatu_db() {
        try {
            Connection konexioa = DriverManager.getConnection(db_url, erabiltzailea, pasahitza);
            System.out.println("Ondo konektatu da");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
