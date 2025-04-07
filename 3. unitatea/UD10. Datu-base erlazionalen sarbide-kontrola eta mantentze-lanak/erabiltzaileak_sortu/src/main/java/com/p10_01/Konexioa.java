package com.p10_01;

import java.sql.Connection;

public class Konexioa 
{
    static final String db_url = "jdbc:mysql://localhost:3306/programazioa";
    static final String erabiltzailea = "root";
    static final String pasahitza = "mysql";


    /**
     * Erabiltzaileak taulan datuak sartzeko metodoa
     * @param konexioa Konektatutako datu-basea
     */
    public void erabiltzaileak_sortu(Connection konexioa) 
    {
        try 
        {
            java.sql.Statement stmt = konexioa.createStatement();
            String sql_insert = "INSERT INTO erabiltzaileak" +
            "(nan, izena, abizena, pasahitza)" +
            "VALUES (123456789, 'Jon', 'Garcia', '1234')";
            stmt.executeUpdate(sql_insert);
            System.out.println("Datuak ondo sartu dira erabiltzaileak taulan");
            stmt.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}