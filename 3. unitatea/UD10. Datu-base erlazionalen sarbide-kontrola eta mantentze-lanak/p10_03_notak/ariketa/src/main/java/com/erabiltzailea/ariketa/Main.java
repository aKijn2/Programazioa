package com.erabiltzailea.ariketa;

import java.sql.Connection;

public class Main 
{
    public static void main(String[] args) 
    {
        try (Connection conn = Konexioa.konektatu()) 
        {
            /**
             * DBra konektatu eta erabiltzaile kudeaketa klasea exekutatu.
             */
            System.out.println("DB konektatuta.");
            ErabiltzaileKudeaketa serv = new ErabiltzaileKudeaketa();
            serv.exekutatuMenua(conn);

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
