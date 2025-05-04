package main.java.com.p10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ErabiltzaileKudeaketa 
{

    private Scanner teklatua = new Scanner(System.in);

    /**
     * Metodoa erabiltzaile berri bat sortzeko.
     * 
     * @param konexioa Datu-basearekin konektatutako Connection objektua
     */
    public void erabiltzaile_kudeaketa(Connection konexioa) 
    {
        try 
        {
            // Erabiltzailearen datuak eskatzea
            System.out.println("Sartu erabiltzailearen nan-a: ");
            String nan = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen izena: ");
            String izena = teklatua.nextLine();

            System.out.println("Sartu erabiltzailearen abizena: ");
            String abizena = teklatua.nextLine();

            System.out.println("Apodoa sortzen...");
            String apodoa = izena.substring(0, 1) + abizena + "01";

            // Apodoa errepikatzen den egiaztatzea
            String egiaztatuErab = "SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement berifikatu = konexioa.prepareStatement(egiaztatuErab);
            berifikatu.setString(1, apodoa);

            int erabKopurua = 0;
            int gehituZenb = 1;

            do 
            {
                ResultSet erabPila = berifikatu.executeQuery();

                if (erabPila.next()) 
                {
                    erabKopurua = erabPila.getInt(1);
                }

                if (erabKopurua > 0) 
                {
                    gehituZenb++;
                    apodoa = izena.substring(0, 1) + abizena + String.format("%02d", gehituZenb);
                    berifikatu.setString(1, apodoa);
                } else 
                {
                    break;
                }

            } while (erabKopurua > 0);
            System.out.println("Apodoa sortu da: " + apodoa);

            // Pasahitza egiaztatzea
            String pasahitza;
            String pasahitzaBi;

            do 
            {
                System.out.println("Sartu erabiltzailearen pasahitza: ");
                pasahitza = teklatua.nextLine();

                System.out.println("Erabiltzailearen pasahitza errepikatu: ");
                pasahitzaBi = teklatua.nextLine();

                if (!pasahitza.equals(pasahitzaBi)) 
                {
                    System.out.println("Pasahitzak ez dira berdinak.");
                } else 
                {
                    System.out.println("Pasahitzak berdinak dira.");
                }

            } while (!pasahitza.equals(pasahitzaBi));

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

            // Erabiltzailea datu-basean sartzea
            String query = "INSERT INTO erabiltzaileak (nan, izena, abizena, erabiltzailea, pasahitza) " +
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
