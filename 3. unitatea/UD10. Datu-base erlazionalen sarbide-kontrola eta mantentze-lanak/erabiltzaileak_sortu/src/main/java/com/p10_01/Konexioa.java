package com.p10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Konexioa 
{

    static final String db_url = "jdbc:mysql://localhost:3306/programazioa";
    static final String erabiltzailea = "root";
    static final String pasahitza = "mysql";

    Scanner teklatua = new Scanner(System.in);

    /**
     * Erabiltzaileak taulan erabiltzaile_berifikatu sartzeko metodoa
     * 
     * @param konexioa Konektatutako datu-basea
     */
    public void erabiltzaile_kudeaketa(Connection konexioa) 
    {
        try 
        {
            System.out.println("Sartu erabiltzailearen nan-a: ");
            String nan = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen izena: ");
            String izena = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen abizena: ");
            String abizena = teklatua.nextLine();

            System.out.println("Apodoa sortzen...");
            String apodoa = izena.substring(0, 1) + abizena + "01";

            /**
             * Erabiltzaileak taulan erabiltzailea errepikatzen den egiaztatu
             */
            String egiaztatuErab = "SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement berifikatu = konexioa.prepareStatement(egiaztatuErab);
            berifikatu.setString(1, apodoa);

            int erabKopurua = 0;
            int gehituZenb = 1;

            do {
                var erabPila = berifikatu.executeQuery();

                if (erabPila.next()) {
                    erabKopurua = erabPila.getInt(1);
                }

                if (erabKopurua > 0) {
                    gehituZenb++;
                    apodoa = izena.substring(0, 1) + abizena + String.format("%02d", gehituZenb);
                    berifikatu.setString(1, apodoa);
                } else {
                    break;
                }

            } while (erabKopurua > 0);
            System.out.println("Apodoa sortu da: " + apodoa);

            String pasahitza;
            String pasahitzaBi;

            /**
             * Buklea errepikatuko da pasahitzak berdinak izan arte.
             */
            do 
            {
                System.out.println("Sartu erabiltzailearen pasahitza: ");
                pasahitza = teklatua.nextLine();

                System.out.println("Erabiltzailearen pasahitza errepikatu: ");
                pasahitzaBi = teklatua.nextLine();

                if (!pasahitza.equals(pasahitzaBi)) 
                {
                    System.out.println("Pasahitzak ez dira berdinak.");
                } 
                else 
                {
                    System.out.println("Pasahitzak berdinak dira.");
                }

            } while (!pasahitza.equals(pasahitzaBi));

            /**
             * Buklea errepikatuko da pasahitzak 6 karaktere gutxienez izan arte.
             */
            do 
            {
                if (pasahitza.length() < 6) 
                {
                    System.out.println("Gutxienez 6 karaktere izan behar ditu");
                } else 
                {
                    System.out.println("Pasahitza ondo sartu da.");
                }
            } while (pasahitza.length() < 6);

            /**
             * SQL irakurketa: erabiltzaileak taulan erabiltzaile_berifikatu sartzeko
             */
            String query = 
            "INSERT INTO erabiltzaileak " + 
            "(nan, izena, abizena, erabiltzailea, pasahitza) " +
            "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = konexioa.prepareStatement(query);

            preparedStatement.setString(1, nan);
            preparedStatement.setString(2, izena);
            preparedStatement.setString(3, abizena);
            preparedStatement.setString(4, apodoa);
            preparedStatement.setString(5, pasahitza);
            preparedStatement.executeUpdate();

            System.out.println("Erabiltzailea sortu da.");

            preparedStatement.close();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}