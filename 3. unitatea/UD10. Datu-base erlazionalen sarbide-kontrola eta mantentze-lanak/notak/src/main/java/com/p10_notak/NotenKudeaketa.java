package com.p10_notak;

import java.sql.*;
import java.util.Scanner;

public class NotenKudeaketa 
{
    private Connection konexioa;
    private Scanner teklatua;

    /**
     * Instantzia berri bat sortzen dugu.
     * @param konexioa Notak kudeatzeko erabiliko den datu-basearen konexioa.
     *                  
     */
    public NotenKudeaketa(Connection konexioa) 
    {
        this.konexioa = konexioa;
        this.teklatua = new Scanner(System.in);
    }

    // Erabiltzaileak izena, abizena, NA zenbakia eta pasahitza sortzeko metodoa
    public void erabiltzaileaSortu()
    {
        System.out.print("Sartu izena: ");
        String izena = teklatua.nextLine();
        
        System.out.print("Sartu abizena: ");
        String abizena = teklatua.nextLine();
        
        System.out.print("Sartu NA zenbakia: ");
        String naZenbakia = teklatua.nextLine();
        
        System.out.print("Sartu pasahitza: ");
        String pasahitza = teklatua.nextLine();
        
        String insertSQL = 
                "INSERT INTO erabiltzaileak (izena, abizena, NA, pasahitza) " +
                "VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement insertStmt = konexioa.prepareStatement(insertSQL);
            insertStmt.setString(1, izena);
            insertStmt.setString(2, abizena);
            insertStmt.setString(3, naZenbakia);
            insertStmt.setString(4, pasahitza);
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ikasle baten notak ikusteko
    public void erakutsiNotakIkaslea(String ikasleErab) 
    {
        try 
        {
            String sql = 
                    "SELECT i.izena, n.ebaluaketa, n.nota, n.oharra " +
                    "FROM notak n " +
                    "JOIN matrikulak m ON n.zeinMatrikula = m.idMatrikula " +
                    "JOIN ikasgaiak i ON m.zeinIkasgai = i.kodea " +
                    "WHERE m.zeinIkasle = ?";

            PreparedStatement stmt = konexioa.prepareStatement(sql);
            stmt.setString(1, ikasleErab);
            ResultSet emaitza = stmt.executeQuery();

            while (emaitza.next()) 
            {
                System.out.println
                    (
                        " | Ikasgaia: "     + emaitza.getString("izena") +
                        " | Ebaluaketa: "   + emaitza.getString("ebaluaketa") +
                        " | Nota: "         + emaitza.getInt("nota") +
                        " | Oharra: "       + emaitza.getString("oharra")
                    );
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
            // Irakaslearen ikasgaiak erakutsi
            String ikasgaiSQL = 
                    "SELECT i.kodea, i.izena FROM ikasgaiak i " +
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

            // Ikasleak erakutsi
            String matrikSQL = 
                    "SELECT m.idMatrikula, e.izena FROM matrikulak m " +
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

            String insertSQL = 
            "INSERT INTO notak " +
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

    // Titore baten ikasleen notak ikusteko
    public void erakutsiTutoreNotak(String tutoreErab) 
    {
        try 
        {
            String sql = 
                    "SELECT e.izena AS ikasleIzena, ik.izena AS ikasgaia, n.ebaluaketa, n.nota " +
                    "FROM erabiltzaileak e " +
                    "JOIN matrikulak m ON e.erabiltzailea = m.zeinIkasle " +
                    "JOIN notak n ON m.idMatrikula = n.zeinMatrikula " +
                    "JOIN ikasgaiak ik ON m.zeinIkasgai = ik.kodea " +
                    "JOIN taldeak t ON ik.zeinTalde = t.idTaldea " +
                    "WHERE t.zeinTutore = ?";

            PreparedStatement stmt = konexioa.prepareStatement(sql);
            stmt.setString(1, tutoreErab);
            ResultSet emaitza = stmt.executeQuery();

            while (emaitza.next()) 
            {
                System.out.println
                    (
                        " | Ikaslea: "      + emaitza.getString("ikasleIzena") +
                        " | Ikasgaia: "     + emaitza.getString("ikasgaia") +
                        " | Ebaluaketa: "   + emaitza.getString("ebaluaketa") +
                        " | Nota: "         + emaitza.getInt("nota")
                    );
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}