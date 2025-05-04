package main.java.com.p10_02;

import java.sql.Connection;
import java.sql.DriverManager;

public class Konexioa 
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/programazioa_eskola";
    static final String USER = "root";
    static final String PASSWORD = "mysql";

    public static Connection konektatu() throws Exception 
    {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
