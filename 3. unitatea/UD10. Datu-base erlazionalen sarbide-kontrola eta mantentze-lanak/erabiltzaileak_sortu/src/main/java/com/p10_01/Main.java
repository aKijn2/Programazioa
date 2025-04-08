package com.p10_01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main 
{
    public static void main(String[] args) 
    {
        Konexioa konexioaObj = new Konexioa();

        /**
         * Datu-basearekin konexioa sortu
         */
        try 
        {
            Connection konexioa = DriverManager.getConnection(
                    Konexioa.db_url,
                    Konexioa.erabiltzailea,
                    Konexioa.pasahitza);
            System.out.println("Datu-basearekin konektatuta.");

            konexioaObj.erabiltzaileak_sortu(konexioa);

            konexioa.close();
            System.out.println("Konexioa itxi da.");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
