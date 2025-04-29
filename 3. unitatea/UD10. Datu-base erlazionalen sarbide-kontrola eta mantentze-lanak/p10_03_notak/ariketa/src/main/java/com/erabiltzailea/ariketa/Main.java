package com.erabiltzailea.ariketa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Konexioa konexioa = new Konexioa();
        Connection connection = null;

        try 
        {
            connection = konexioa.getKonekzioa();
            if (connection != null) 
            {
                System.out.println("Datu basearekin konexioa ondo egin da.");
            } else 
            {
                System.out.println("Errorea konexioa egiten.");
            }

            // Taula sortu
            Erabiltzaileak.sortuTaula(connection);

            // Saioa hasteko metodoa.
            boolean saioaHasiDa = Erabiltzaileak.saioaHasi(connection, sc);
            if (!saioaHasiDa) 
            {
                System.out.println("Ezin izan duzu saioa hasi. Itxi aplikazioa.");
                return;
            }

        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea datu basearekin konexioa egiten.");
        }
    }
}