package com.p10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Konexioa {
    static final String db_url = "jdbc:mysql://localhost:3306/programazioa";
    static final String erabiltzailea = "root";
    static final String pasahitza = "mysql";

    Scanner sc = new Scanner(System.in);

    /**
     * Erabiltzaileak taulan datuak sartzeko metodoa
     * 
     * @param konexioa Konektatutako datu-basea
     */
    public void erabiltzaileak_sortu(Connection konexioa) {
        try {
            System.out.println("Sartu erabiltzailearen nan-a: ");
            String nan = sc.nextLine();

            System.out.println("Sartu erabiltzailearen izena: ");
            String izena = sc.nextLine();

            System.out.println("Sartu erabiltzailearen abizena: ");
            String abizena = sc.nextLine();

            System.out.println("Sartu erabiltzailearen apodoa: ");
            String apodoa = sc.nextLine();

            String pasahitza;
            String pasahitzaErrepikatu;
            do {
                System.out.println("Sartu erabiltzailearen pasahitza: ");
                pasahitza = sc.nextLine();

                System.out.println("Erabiltzailearen pasahitza errepikatu: ");
                pasahitzaErrepikatu = sc.nextLine();

                /**
                 * Mezua hitzuli kondizioaren arabera
                 */
                if (!pasahitza.equals(pasahitzaErrepikatu)) {
                    System.out.println("Pasahitzak ez dira berdinak. Saiatu berriro.");
                } else {
                    System.out.println("Pasahitzak berdinak dira.");
                }

            } while (!pasahitza.equals(pasahitzaErrepikatu));

            /**
             * SQL irakurketa: erabiltzaileak taulan datuak sartzeko
             */
            String query = "INSERT INTO erabiltzaileak (nan, izena, abizena, erabiltzailea, pasahitza) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = konexioa.prepareStatement(query);
            preparedStatement.setString(1, nan);
            preparedStatement.setString(2, izena);
            preparedStatement.setString(3, abizena);
            preparedStatement.setString(4, apodoa);
            preparedStatement.setString(5, pasahitza);
            preparedStatement.executeUpdate();
            System.out.println("Erabiltzailea sortu da.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}