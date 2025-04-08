package com.p10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Konexioa {
    static final String db_url = "jdbc:mysql://localhost:3306/programazioa";
    static final String erabiltzailea = "root";
    static final String pasahitza = "mysql";

    Scanner teklatua = new Scanner(System.in);

    /**
     * Erabiltzaileak taulan datuak sartzeko metodoa
     * 
     * @param konexioa Konektatutako datu-basea
     */
    public void erabiltzaileak_sortu(Connection konexioa) {
        try {
            System.out.println("Sartu erabiltzailearen nan-a: ");
            String nan = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen izena: ");
            String izena = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen abizena: ");
            String abizena = teklatua.nextLine();

            System.out.println("Apodoa sortzen...");
            String apodoa = izena.substring(0, 1) + abizena + "01";

            // Ikusi apodoa existitzen den
            String ikusiBadagoen = "SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ?";

            PreparedStatement berifikatu = konexioa.prepareStatement(ikusiBadagoen);
            berifikatu.setString(1, apodoa);

            int kontatu = 0;

            do {
                var erantzunenPila = berifikatu.executeQuery();
                if (erantzunenPila.next()) {
                    kontatu = erantzunenPila.getInt(1);
                }

                if (kontatu > 0) {
                    // Apodoa existitzen bada, apodoa aldatuko da
                    if (apodoa.length() < izena.length() + abizena.length() + 2) {
                        apodoa = izena.substring(0, apodoa.length() - abizena.length() - 2 + 1) + abizena + "01";
                    } else {
                        int number = Integer.parseInt(apodoa.substring(apodoa.length() - 2)) + 1;
                        apodoa = apodoa.substring(0, apodoa.length() - 2) + String.format("%02d", number);
                    }
                }
            } while (kontatu > 0);

            System.out.println("Apodoa sortu da: " + apodoa);

            String pasahitza;
            String pasahitzaErrepikatu;

            /**
             * Buklea errepikatuko da pasahitzak berdinak izan arte.
             */
            do {
                System.out.println("Sartu erabiltzailearen pasahitza: ");
                pasahitza = teklatua.nextLine();

                System.out.println("Erabiltzailearen pasahitza errepikatu: ");
                pasahitzaErrepikatu = teklatua.nextLine();

                if (!pasahitza.equals(pasahitzaErrepikatu)) {
                    System.out.println("Pasahitzak ez dira berdinak. Saiatu berriro.");
                } else {
                    System.out.println("Pasahitzak berdinak dira.");
                }

            } while (!pasahitza.equals(pasahitzaErrepikatu));

            /**
             * Buklea errepikatuko da pasahitzak 6 karaktere gutxienez izan arte.
             */
            do {
                if (pasahitza.length() < 6) {
                    System.out.println("Erabiltzailearen pasahitza gutxienez 6 karaktere izan behar ditu.");
                } else {
                    System.out.println("Pasahitza ondo sartu da.");
                }
            } while (pasahitza.length() < 6);

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