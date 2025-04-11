package com.p10_01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        Konexioa konektatu = new Konexioa();

        /**
         * Datu-basearekin konexioa sortu
         */
        try {
            Connection konexioa = DriverManager.getConnection
                (
                    Konexioa.db_url,
                    Konexioa.erabiltzailea,
                    Konexioa.pasahitza
                );

            System.out.println("Datu-basearekin konektatuta.");

            konektatu.erabiltzaile_kudeaketa(konexioa);
            konexioa.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
