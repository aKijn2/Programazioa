package com.p10_notak;

import java.sql.*;
import java.util.*;

public class NotenKudeaketa 
{
    private Connection konexioa;
    private Scanner teklatua;
    private Map<String, Integer> saiakerak;

    public NotenKudeaketa(Connection konexioa) 
    {
        this.konexioa = konexioa;
        this.teklatua = new Scanner(System.in);
        this.saiakerak = new HashMap<>();
    }

    // ERABILTZAILE SORTZEKO METODOA
    public void erabiltzaileaSortu()
    {
        try
        {
            System.out.print("Sartu izena eta abizena (adb: Asa Alla): ");
            String izenaAbizena = teklatua.nextLine().trim();
    
            String[] izenAbizenak = izenaAbizena.split("\\s+", 2);
    
            if (izenAbizenak.length < 2)
            {
                System.out.println("Mesedez, sartu izena eta abizena bananduta.");
                return;
            }
    
            String izena = izenAbizenak[0].toLowerCase();
            String abizena = izenAbizenak[1].toLowerCase();
    
            System.out.print("Sartu NA zenbakia: ");
            String naZenbakia = teklatua.nextLine();
    
            String pasahitza1, pasahitza2;
            do {
                System.out.print("Sartu pasahitza (gutxienez 6 karaktere): ");
                pasahitza1 = teklatua.nextLine();
                System.out.print("Berretsi pasahitza: ");
                pasahitza2 = teklatua.nextLine();
    
                if (!pasahitza1.equals(pasahitza2)) {
                    System.out.println("Pasahitzak ez dira berdinak. Saiatu berriro.");
                } else if (pasahitza1.length() < 6) {
                    System.out.println("Pasahitza motzegia da. Gutxienez 6 karaktere behar dira.");
                }
            } while (!pasahitza1.equals(pasahitza2) || pasahitza1.length() < 6);
    
            System.out.print("Sartu mota (ikasle/irakasle): ");
            String mota = teklatua.nextLine().toLowerCase();
    
            // Erabiltzaile-izena sortu
            String erabiltzaileIzena = sortuErabiltzaileIzena(izena, abizena);
    
            String insertSQL = "INSERT INTO erabiltzaileak (erabiltzailea, izena, NA, pasahitza, mota) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = konexioa.prepareStatement(insertSQL);
            insertStmt.setString(1, erabiltzaileIzena);
            insertStmt.setString(2, izenaAbizena); // Hemen izena + abizena gordetzen da
            insertStmt.setString(3, naZenbakia);
            insertStmt.setString(4, pasahitza1);
            insertStmt.setString(5, mota);
    
            insertStmt.executeUpdate();
    
            System.out.println("Erabiltzailea sortu da: " + erabiltzaileIzena);
            listatuErabiltzaileak();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    

    private String sortuErabiltzaileIzena(String izena, String abizena) throws SQLException 
    {
        String baseErab = izena.substring(0, 1) + abizena;
        baseErab = baseErab.toLowerCase().replaceAll("\\s+", "");

        String erabiltzailea = baseErab;
        int letraPos = 1;
        int zenb = 1;

        while (badagoErabiltzailea(erabiltzailea)) 
        {
            if (letraPos < izena.length()) 
            {
                erabiltzailea = izena.substring(0, letraPos + 1) + abizena;
                erabiltzailea = erabiltzailea.toLowerCase().replaceAll("\\s+", "");
                letraPos++;
            } else 
            {
                erabiltzailea = baseErab + String.format("%02d", zenb);
                zenb++;
            }
        }
        return erabiltzailea;
    }

    private boolean badagoErabiltzailea(String erabiltzailea) throws SQLException 
    {
        String sql = "SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ?";
        PreparedStatement stmt = konexioa.prepareStatement(sql);
        stmt.setString(1, erabiltzailea);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    private void listatuErabiltzaileak() throws SQLException
    {
        String sql = "SELECT erabiltzailea, izena, mota FROM erabiltzaileak";
        Statement stmt = konexioa.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    
        System.out.println("== Erabiltzaileak ==");
        while (rs.next())
        {
            System.out.println(rs.getString("erabiltzailea") + " - " + rs.getString("izena") + " (" + rs.getString("mota") + ")");
        }
    }
    

    // SAIOA HASI
    public void saioaHasi() 
    {
        try 
        {
            System.out.print("Sartu erabiltzaile izena: ");
            String erabiltzailea = teklatua.nextLine();

            if (saiakerak.containsKey(erabiltzailea) && saiakerak.get(erabiltzailea) >= 3) 
            {
                System.out.println("Blokeatuta zaude. Itxaron 15 segundo...");
                Thread.sleep(15000);
                saiakerak.put(erabiltzailea, 0);
            }

            System.out.print("Sartu pasahitza: ");
            String pasahitza = teklatua.nextLine();

            String sql = "SELECT izena, abizena, mota FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";
            PreparedStatement stmt = konexioa.prepareStatement(sql);
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) 
            {
                System.out.println("Ongi etorri: " + rs.getString("izena") + " " + rs.getString("abizena") + " ("
                        + rs.getString("mota") + ")");
                saiakerak.put(erabiltzailea, 0);
            } else 
            {
                System.out.println("Errorea: erabiltzaile izena edo pasahitza okerra.");
                saiakerak.put(erabiltzailea, saiakerak.getOrDefault(erabiltzailea, 0) + 1);
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // NOTAK KUDEATZEKO MENUA (ikus/sartu notak)
    public void menuNotak(String erabiltzaileIzena) 
    {
        try 
        {
            String sql = "SELECT mota FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement stmt = konexioa.prepareStatement(sql);
            stmt.setString(1, erabiltzaileIzena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) 
            {
                String mota = rs.getString("mota");
                if (mota.equals("ikasle")) 
                {
                    erakutsiNotakIkaslea(erabiltzaileIzena);
                } else if (mota.equals("irakasle")) 
                {
                    sartuNota(erabiltzaileIzena);
                } else 
                {
                    System.out.println("Ezagutzen ez den mota: " + mota);
                }
            } else 
            {
                System.out.println("Erabiltzailea ez da existitzen.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    // Ikasle baten notak ikusteko
    public void erakutsiNotakIkaslea(String ikasleErab) 
    {
        try 
        {
            String sql = "SELECT i.izena, n.ebaluaketa, n.nota, n.oharra " +
                    "FROM notak n " +
                    "JOIN matrikulak m ON n.zeinMatrikula = m.idMatrikula " +
                    "JOIN ikasgaiak i ON m.zeinIkasgai = i.kodea " +
                    "WHERE m.zeinIkasle = ?";

            PreparedStatement stmt = konexioa.prepareStatement(sql);
            stmt.setString(1, ikasleErab);
            ResultSet emaitza = stmt.executeQuery();

            while (emaitza.next()) 
            {
                System.out.println(
                        " | Ikasgaia: " + emaitza.getString("izena") +
                                " | Ebaluaketa: " + emaitza.getString("ebaluaketa") +
                                " | Nota: " + emaitza.getInt("nota") +
                                " | Oharra: " + emaitza.getString("oharra"));
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Irakasle batek bere ikasgaietako notak sartzeko
    public void sartuNota(String irakasleErab) 
    {
        try 
        {
            String ikasgaiSQL = "SELECT i.kodea, i.izena FROM ikasgaiak i " +
                    "JOIN irakasle_irakats ir ON ir.zeinIkasgai = i.kodea " +
                    "WHERE ir.zeinIrakasle = ?";

            PreparedStatement ikasgaiStmt = konexioa.prepareStatement(ikasgaiSQL);
            ikasgaiStmt.setString(1, irakasleErab);
            ResultSet ikasgaiak = ikasgaiStmt.executeQuery();

            System.out.println("Zure ikasgaiak:");
            while (ikasgaiak.next()) 
            {
                System.out.println(ikasgaiak.getInt("kodea") + " - " + ikasgaiak.getString("izena"));
            }

            System.out.print("Sartu ikasgai kodea: ");
            int ikasgaiKodea = teklatua.nextInt();
            teklatua.nextLine();

            String matrikSQL = "SELECT m.idMatrikula, e.izena FROM matrikulak m " +
                    "JOIN erabiltzaileak e ON m.zeinIkasle = e.erabiltzailea " +
                    "WHERE m.zeinIkasgai = ?";

            PreparedStatement matrikStmt = konexioa.prepareStatement(matrikSQL);
            matrikStmt.setInt(1, ikasgaiKodea);
            ResultSet matrikulak = matrikStmt.executeQuery();

            System.out.println("Matrikulatutako ikasleak:");
            while (matrikulak.next()) 
            {
                System.out.println(matrikulak.getInt("idMatrikula") + " - " + matrikulak.getString("izena"));
            }

            System.out.print("Sartu matrikula ID: ");
            int matrikulaId = teklatua.nextInt();
            teklatua.nextLine();

            System.out.print("Sartu ebaluaketa: ");
            String ebaluaketa = teklatua.nextLine();

            System.out.print("Sartu nota: ");
            int nota = teklatua.nextInt();
            teklatua.nextLine();

            System.out.print("Sartu oharra: ");
            String oharra = teklatua.nextLine();

            String insertSQL = "INSERT INTO notak " +
                    "(zeinMatrikula, ebaluaketa, nota, oharra ) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = konexioa.prepareStatement(insertSQL);

            insertStmt.setInt(1, matrikulaId);
            insertStmt.setString(2, ebaluaketa);
            insertStmt.setInt(3, nota);
            insertStmt.setString(4, oharra);
            insertStmt.executeUpdate();

            System.out.println("Nota ondo gehitu da.");

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
