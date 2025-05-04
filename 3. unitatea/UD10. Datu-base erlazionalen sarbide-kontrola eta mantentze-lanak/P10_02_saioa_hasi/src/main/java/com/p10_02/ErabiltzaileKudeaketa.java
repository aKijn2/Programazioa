package main.java.com.p10_02;

import java.sql.*;
import java.util.Scanner;

/**
 * Erabiltzaileen kudeaketa klasea, erabiltzaileak sortu, kontsultatu eta saioa hasi ahal izateko.
 */
public class ErabiltzaileKudeaketa 
{

    private final Scanner sc = new Scanner(System.in);
    
    private final String[] erabiltzaileIzenak = new String[100]; 
    private int erabiltzaileKopurua = 0;

    /**
     * Menu nagusia exekutatzen du, erabiltzaileari aukerak emanez.
     *
     * @param Konexioa Datu-basearen konexioa
     */
    public void exekutatuMenua(Connection Konexioa) 
    {
        int aukera;
        do 
        {
            System.out.println("\n1. Erabiltzailea sortu\n2. Erabiltzaileak ikusi\n3. Saioa hasi\n0. Irten\n");
            aukera = Integer.parseInt(sc.nextLine());

            try 
            {
                switch (aukera) 
                {
                    case 1 -> erabiltzaileaSortu(Konexioa);
                    case 2 -> erabiltzaileaIkusi(Konexioa);
                    case 3 -> saioaHasi(Konexioa);
                    case 0 -> System.out.println("Irten egiten...");
                    default -> System.out.println("Aukera okerra.");
                }
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        } while (aukera != 0);
    }

    /**
     * Erabiltzaile berri bat sortzen du datu-basean.
     *
     * @param Konexioa Datu-basearen konexioa
     */
    private void erabiltzaileaSortu(Connection Konexioa) throws Exception 
    {
        System.out.print("Nan: ");
        String nan = sc.nextLine();

        System.out.print("Izena: ");
        String izena = sc.nextLine();

        System.out.print("Abizena: ");
        String abizena = sc.nextLine();

        System.out.print("Mota (irakaslea/ikaslea): ");
        String mota = sc.nextLine().toLowerCase();

        String pasahitza;
        while (true) 
        {
            System.out.print("Pasahitza: ");
            pasahitza = sc.nextLine();

            System.out.print("Pasahitza berriz: ");
            String berriz = sc.nextLine();

            if (!pasahitza.equals(berriz)) 
            {
                System.out.println("Pasahitzak ez dira berdinak.");
            } else if (pasahitza.length() < 6) 
            {
                System.out.println("Pasahitzak gutxienez 6 karaktere izan behar ditu.");
            } else break;
        }

        String erabiltzaileIzena = Utils.sortuErabiltzaileIzena(Konexioa, izena, abizena);

        String sql = "INSERT INTO erabiltzaileak (nan, izena, abizena, erabiltzailea, pasahitza, mota) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = Konexioa.prepareStatement(sql);
        ps.setString(1, nan);
        ps.setString(2, izena);
        ps.setString(3, abizena);
        ps.setString(4, erabiltzaileIzena);
        ps.setString(5, pasahitza);
        ps.setString(6, mota);
        ps.executeUpdate();

        erabiltzaileIzenak[erabiltzaileKopurua++] = erabiltzaileIzena; // Erabiltzaile izena gorde
        System.out.println("Erabiltzailea sortua: " + erabiltzaileIzena);
    }

    /**
     * NAN baten arabera erabiltzailearen informazioa erakusten du.
     *
     * @param Konexioa Datu-basearen konexioa
     */
    private void erabiltzaileaIkusi(Connection Konexioa) throws Exception 
    {
        System.out.print("Sartu NAN-a: ");

        String nan = sc.nextLine();
        String sql = "SELECT * FROM erabiltzaileak WHERE nan = ?";

        PreparedStatement ps = Konexioa.prepareStatement(sql);
        ps.setString(1, nan);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) 
        {
            System.out.printf("Erabiltzailea: %s %s (%s)%n", rs.getString("izena"), rs.getString("abizena"), rs.getString("mota"));
        } else 
        {
            System.out.println("Ez da aurkitu.");
        }
    }

    /**
     * Erabiltzaile batek saioa hasteko aukera ematen du.
     *
     * @param Konexioa Datu-basearen konexioa
     */
    private void saioaHasi(Connection Konexioa) throws Exception 
    {
        System.out.print("Erabiltzaile izena: ");
        String erabiltzailea = sc.nextLine();

        // Erabiltzailearen posizioa bilatu
        boolean aurkitu = false;
        for (int i = 0; i < erabiltzaileKopurua; i++) 
        {
            if (erabiltzaileIzenak[i].equals(erabiltzailea)) 
            {
                aurkitu = true;
                break;
            }
        }

        if (aurkitu) 
        {
            System.out.print("Pasahitza: ");
            String pasahitza = sc.nextLine();
            String sql = "SELECT izena, abizena, mota FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";
            PreparedStatement ps = Konexioa.prepareStatement(sql);
            ps.setString(1, erabiltzailea);
            ps.setString(2, pasahitza);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                System.out.printf("Ongi etorri %s %s (%s)%n", rs.getString("izena"), rs.getString("abizena"), rs.getString("mota"));
            } else 
            {
                System.out.println("Errorea: erabiltzailea edo pasahitza okerra.");
            }
        } else 
        {
            System.out.println("Erabiltzaile hori ez dago erregistroan.");
        }
    }
}
