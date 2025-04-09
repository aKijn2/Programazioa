package com.p10_notak;

import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa 
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/programazioa_eskola";
    static final String ERABILTZAILEA = "root";
    static final String PASAHITZA = "pass";

    public Connection konektatu_db() 
    {
        Connection kone = null;
        try 
        {
            kone = DriverManager.getConnection(DB_URL, ERABILTZAILEA, PASAHITZA);
            System.out.println("Ondo konektatu da");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return kone;
    }
}
