package com.erabiltzailea.ariketa;

import java.sql.*;
import java.util.Scanner;

/**
 * Erabiltzaileekin lotutako funtzio nagusiak kudeatzen dituen klasea:
 * sortzea, kontsultatzea, saioa hastea eta notak kudeatzea.
 */
public class ErabiltzaileKudeaketa 
{

    private final Scanner sc = new Scanner(System.in);
    private final String[] erabiltzaileIzenak = new String[100];
    private int erabiltzaileKopurua = 0;

    /**
     * Menu nagusia exekutatu eta aukera guztiak erakusten ditu.
     * 
     * @param konexioa Datu-basearen konexioa
     */
    public void exekutatuMenua(Connection konexioa) 
    {
        int aukera;
        do 
        {
            System.out.println("\n1. Erabiltzailea sortu\n2. Erabiltzailea ikusi\n3. Saioa hasi\n0. Irten\n");
            aukera = Integer.parseInt(sc.nextLine());
            try 
            {
                switch (aukera) 
                {
                    case 1 -> sortuErabiltzailea(konexioa);
                    case 2 -> erakutsiErabiltzailea(konexioa);
                    case 3 -> hasiSaioa(konexioa);
                    case 0 -> System.out.println("Programa amaitzen...");
                    default -> System.out.println("Aukera okerra.");
                }
            } catch (Exception e) 
            {
                System.out.println("Errorea gertatu da: " + e.getMessage());
            }
        } while (aukera != 0);
    }

    /**
     * Erabiltzaile berri bat sortzen du datu-basean.
     * 
     * @param konexioa Datu-basearen konexioa
     */
    private void sortuErabiltzailea(Connection konexioa) throws Exception 
    {
        System.out.print("NAN: ");
        String nan = sc.nextLine();

        System.out.print("Izena: ");
        String izena = sc.nextLine();

        System.out.print("Abizena: ");
        String abizena = sc.nextLine();

        System.out.print("Mota (irakaslea/ikaslea/tutorea): ");
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
            } else
                break;
        }

        String erabiltzaileIzena = ErabiltzaileBalidatu.sortuErabiltzaileIzena(konexioa, izena, abizena);
        String sql = "INSERT INTO erabiltzaileak (nan, izena, abizena, erabiltzailea, pasahitza, mota) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = konexioa.prepareStatement(sql);

        ps.setString(1, nan);
        ps.setString(2, izena);
        ps.setString(3, abizena);
        ps.setString(4, erabiltzaileIzena);
        ps.setString(5, pasahitza);
        ps.setString(6, mota);
        ps.executeUpdate();

        erabiltzaileIzenak[erabiltzaileKopurua] = erabiltzaileIzena;
        erabiltzaileKopurua++;

        System.out.println("Erabiltzailea sortua: " + erabiltzaileIzena);
    }

    /**
     * NAN baten arabera erabiltzailearen informazioa erakusten du.
     * 
     * @param konexioa Datu-basearen konexioa
     */
    private void erakutsiErabiltzailea(Connection konexioa) throws Exception 
    {
        System.out.print("Sartu NAN-a: ");
        String nan = sc.nextLine();
        String sql = "SELECT * FROM erabiltzaileak WHERE nan = ?";

        PreparedStatement ps = konexioa.prepareStatement(sql);
        ps.setString(1, nan);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) 
        {
            System.out.printf("Erabiltzailea: %s %s (%s)%n", rs.getString("izena"), rs.getString("abizena"),
                    rs.getString("mota"));
        } else 
        {
            System.out.println("Ez da aurkitu NAN hori duen erabiltzailea.");
        }
    }

    /**
     * Erabiltzaile batek saioa hasteko aukera ematen du.
     * 
     * @param konexioa Datu-basearen konexioa
     */
    private void hasiSaioa(Connection konexioa) throws Exception 
    {
        System.out.print("Erabiltzaile izena: ");
        String erabiltzailea = sc.nextLine();

        System.out.print("Pasahitza: ");
        String pasahitza = sc.nextLine();

        String sql = "SELECT izena, abizena, mota FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";

        PreparedStatement ps = konexioa.prepareStatement(sql);
        ps.setString(1, erabiltzailea);
        ps.setString(2, pasahitza);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) 
        {
            System.out.printf("Ongi etorri %s %s (%s)%n", rs.getString("izena"), rs.getString("abizena"),
                    rs.getString("mota"));

            String mota = rs.getString("mota");
            switch (mota) 
            {
                case "ikaslea" -> ikasleaNotakIkusi(konexioa, erabiltzailea);
                case "irakaslea" -> irakasleaNotakSartu(konexioa, erabiltzailea);
                case "tutorea" -> tutoreaNotakIkusi(konexioa, erabiltzailea);
            }
        } else 
        {
            System.out.println("Errorea: erabiltzailea edo pasahitza okerra.");
        }
    }

    /**
     * Ikasleak bere notak ikusi ditzake.
     * 
     * @param konexioa          Datu-basearen konexioa
     * @param erabiltzailea Ikaslearen erabiltzailea
     */
    private void ikasleaNotakIkusi(Connection konexioa, String erabiltzailea) throws SQLException 
    {
        String sql = "SELECT n.ebaluaketa, n.nota FROM notak n " +
                "JOIN matrikulak m ON n.zeinMatrikula = m.idMatrikula " +
                "WHERE m.zeinIkasle = ?";

        PreparedStatement ps = konexioa.prepareStatement(sql);
        ps.setString(1, erabiltzailea);
        ResultSet rs = ps.executeQuery();

        System.out.println("Zure Notak:");
        while (rs.next()) 
        {
            System.out.printf("Ebaluaketa: %s, Nota: %d%n", rs.getString("ebaluaketa"), rs.getInt("nota"));
        }
    }

    /**
     * Irakasleak bere ikasgaiko notak sartu ditzake.
     * 
     * @param konexioa          Datu-basearen konexioa
     * @param erabiltzailea Irakaslearen erabiltzailea
     */
    private void irakasleaNotakSartu(Connection konexioa, String erabiltzailea) throws SQLException 
    {
        System.out.print("Sartu ikasgaiaren kodea: ");
        int kodea = Integer.parseInt(sc.nextLine());

        System.out.print("Sartu ebaluaketa: ");
        String ebaluaketa = sc.nextLine();

        System.out.print("Sartu nota: ");
        int nota = Integer.parseInt(sc.nextLine());

        System.out.print("Sartu oharra (aukeraezkoa): ");
        String oharra = sc.nextLine();

        String sql = "SELECT idMatrikula FROM matrikulak WHERE zeinIkasgai = ?";
        PreparedStatement ps = konexioa.prepareStatement(sql);
        ps.setInt(1, kodea);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) 
        {
            int idMatrikula = rs.getInt("idMatrikula");

            String insertSQL = "INSERT INTO notak (zeinMatrikula, ebaluaketa, nota, oharra) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = konexioa.prepareStatement(insertSQL);
            psInsert.setInt(1, idMatrikula);
            psInsert.setString(2, ebaluaketa);
            psInsert.setInt(3, nota);
            psInsert.setString(4, oharra);
            psInsert.executeUpdate();
        }
        System.out.println("Notak sartu dira.");
    }

    /**
     * Tutoreak bere ikasleen notak ikusi ditzake.
     * 
     * @param konexioa          Datu-basearen konexioa
     * @param erabiltzailea Tutorearen erabiltzailea
     */
    private void tutoreaNotakIkusi(Connection konexioa, String erabiltzailea) throws SQLException 
    {
        String sql = "SELECT i.erabiltzailea, n.ebaluaketa, n.nota " +
                "FROM notak n " +
                "JOIN matrikulak m ON n.zeinMatrikula = m.idMatrikula " +
                "JOIN erabiltzaileak i ON m.zeinIkasle = i.erabiltzailea " +
                "WHERE m.zeinTutore = ?";
        PreparedStatement ps = konexioa.prepareStatement(sql);
        ps.setString(1, erabiltzailea);
        ResultSet rs = ps.executeQuery();

        System.out.println("Ikasleen Notak:");
        while (rs.next()) 
        {
            System.out.printf("Ikaslea: %s, Ebaluaketa: %s, Nota: %d%n",
                    rs.getString("erabiltzailea"),
                    rs.getString("ebaluaketa"),
                    rs.getInt("nota"));
        }
    }
}
