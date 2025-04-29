package com.p10_notak;

import java.sql.*;
import java.util.*;

public class NotenKudeaketa 
{
    private Connection konexioa;
<<<<<<< HEAD
    private Map<String, Integer> saiakerak;
    private String Erabiltzaileak;
=======
    private Scanner teklatua;
    private Map<String, Integer> saiakerak;
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e

    public NotenKudeaketa(Connection konexioa) 
    {
        this.konexioa = konexioa;
<<<<<<< HEAD
        this.saiakerak = new HashMap<>();
    }

    // region Erabiltzailea gehitzeko metodoa.
    public void erabiltzaileaGehitu(Connection konexioa, Scanner teklatua) 
    {
        try 
        {
            System.out.println("Nan: ");
            int nan = teklatua.nextInt();
=======
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
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e

            System.out.println("Izena: ");
            String izena = teklatua.next();

            System.out.println("Abizena: ");
            String abizena = teklatua.next();

            System.out.println("Mota (ikaslea/irakaslea): ");
            String mota = teklatua.next();

            String erabiltzailea = izena.substring(0, 1).toLowerCase() + abizena.toLowerCase();

            // Ikusi ea erabiltzailea existitzen den.
            String erabiltzaileaExistitzenBaldinBada = "SELECT * FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement preparedStatementErabiltzaileaExistitzenBaldinBada = konexioa
                    .prepareStatement(erabiltzaileaExistitzenBaldinBada);
            preparedStatementErabiltzaileaExistitzenBaldinBada.setString(1, erabiltzailea);
            ResultSet resultSet = preparedStatementErabiltzaileaExistitzenBaldinBada.executeQuery();

            // Erabiltzailea existitzen bada, erabiltzailea, zenbakia gehituko di.
            if (resultSet.next()) 
            {
<<<<<<< HEAD
                int count = 1;
                while (resultSet.next()) 
                {
                    count++;
                }
                erabiltzailea = izena.substring(0, 1).toLowerCase() + abizena.toLowerCase() + count;
=======
                System.out.println(
                        " | Ikasgaia: " + emaitza.getString("izena") +
                                " | Ebaluaketa: " + emaitza.getString("ebaluaketa") +
                                " | Nota: " + emaitza.getInt("nota") +
                                " | Oharra: " + emaitza.getString("oharra"));
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e
            }

            System.out.println("Pasahitza: ");
            String pasahitza1 = teklatua.next();

            System.out.println("Pasahitza berriro sartu: ");
            String pasahitza2 = teklatua.next();

            if (!pasahitza1.equals(pasahitza2)) 
            {
                System.out.println("Errorea: Pasahitzak ez dira berdinak.");
                return;
            }

            if (pasahitza1.length() < 6) 
            {
                System.out.println("Errorea: Pasahitzak gutxienez 6 karaktere izan behar ditu.");
                return;
            }

            // Query exekutatu erabiltzailea datu basean kartzeko.
            String insertQuery = "INSERT INTO erabiltzaileak (nan, izena, abizena, erabiltzailea, pasahitza, mota) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = konexioa.prepareStatement(insertQuery);
            preparedStatement.setInt(1, nan);
            preparedStatement.setString(2, izena);
            preparedStatement.setString(3, abizena);
            preparedStatement.setString(4, erabiltzailea);
            preparedStatement.setString(5, pasahitza1);
            preparedStatement.setString(6, mota);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) 
            {
                System.out.println("Erabiltzailea ongi gehitu da.");
            } else 
            {
                System.out.println("Errorea erabiltzailea gehitzean.");
            }

            // List users after adding a new user
            erabiltzaileakListatu(konexioa);
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzailea gehitzean.");
        }
    }
    // endregion

    /**
     * Metodo hau datu baseko erabiltzaileen zerrenda erakusten du.
     *
     * @param connection Datu basearekin konexioa
     */

    public void erabiltzaileakListatu(Connection connection) 
    {
        try 
        {
<<<<<<< HEAD
            String selectQuery = "SELECT * FROM erabiltzaileak";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
=======
            String ikasgaiSQL = "SELECT i.kodea, i.izena FROM ikasgaiak i " +
                    "JOIN irakasle_irakats ir ON ir.zeinIkasgai = i.kodea " +
                    "WHERE ir.zeinIrakasle = ?";
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e

            System.out.println("Erabiltzaileak:");
            while (resultSet.next()) 
            {
                int nan = resultSet.getInt("nan");
                String izena = resultSet.getString("izena");
                String abizena = resultSet.getString("abizena");
                String erabiltzailea = resultSet.getString("erabiltzailea");
                String mota = resultSet.getString("mota");

                System.out.println("NAN: " + nan + ", Izena: " + izena + ", Abizena: " + abizena + ", Erabiltzailea: "
                        + erabiltzailea + ", Mota: " + mota);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzaileak listatzean.");
        }
    }
    // endregion

    /**
     * Metodo hau erabiltzaile bat ezabatzen du datu basean.
     *
     * @param erabiltzaileaEzabatu
     */

    public void erabiltzaileaEzabatu(Connection connection, Scanner teklatua) 
    {
        try 
        {
            System.out.println("Sartu erabiltzailearen izena: ");
            String erabiltzailea = teklatua.next();

            String deleteQuery = "DELETE FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, erabiltzailea);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) 
            {
                System.out.println("Erabiltzailea ongi ezabatu da.");
            } else 
            {
                System.out.println("Errorea erabiltzailea ezabatzean. Erabiltzailea ez da aurkitu.");
            }

            erabiltzaileakListatu(connection);
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzailea ezabatzean.");
        }
    }

<<<<<<< HEAD
    // endregion
=======
            String matrikSQL = "SELECT m.idMatrikula, e.izena FROM matrikulak m " +
                    "JOIN erabiltzaileak e ON m.zeinIkasle = e.erabiltzailea " +
                    "WHERE m.zeinIkasgai = ?";
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e

    /**
     * Metodo hau saioa hasi eta erabiltzailea autentifikatzen du.
     *
     * @return boolean - Saioa ondo hasi den ala ez
     */

    public boolean saioaHasi(Connection connection, Scanner teklatua) 
    {
        int saiakeraKop = 0;
        while (saiakeraKop < 3) 
        {
            try 
            {
                System.out.println("Erabiltzaile-izena: ");
                String erabiltzaileIzena = teklatua.nextLine();

                System.out.println("Pasahitza: ");
                String pasahitza = teklatua.nextLine();

                String selectQuery = "SELECT * FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setString(1, erabiltzaileIzena);
                preparedStatement.setString(2, pasahitza);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) 
                {
                    String izena = resultSet.getString("izena");
                    String abizena = resultSet.getString("abizena");
                    String mota = resultSet.getString("mota");

                    System.out.println("Saioa hasi da.");
                    System.out.println("Erabiltzailearen izena-abizena: " + izena + " " + abizena);
                    System.out.println("Mota: " + mota);

                    switch (mota) 
                    {
                        case "ikaslea":
                            while (true) 
                            {
                                System.out.println("\nAukeratu ekintza:");
                                System.out.println("1. Notak ikusi");
                                System.out.println("0. Irten");

                                int aukera = teklatua.nextInt();
                                teklatua.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.ikasleakNotakIkusi(connection, teklatua, erabiltzaileIzena);
                                        break;
                                    default:
                                        System.out.println("Aukera baliogabea.");
                                }
                            }
                        case "irakaslea":
                            while (true) 
                            {
                                System.out.println("\nAukeratu ekintza:");
                                System.out.println("1. Notak sartu");
                                System.out.println("0. Irten");

                                int aukera = teklatua.nextInt();
                                teklatua.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.irakasleakNotakSartu(connection, teklatua, erabiltzaileIzena);
                                        break;
                                    default:
                                        System.out.println("Aukera baliogabea.");
                                }
                            }
                        case "admin":
                            while (true) 
                            {
                                System.out.println("\nAukeratu ekintza:");
                                System.out.println("1. Taula sortu");
                                System.out.println("2. Erabiltzaile berria gehitu");
                                System.out.println("3. Erabiltzaileak listatu");
                                System.out.println("4. Erabiltzaileak Ezabatu");
                                System.out.println("0. Irten");

                                int aukera = teklatua.nextInt();
                                teklatua.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.taulaGehitu(connection);
                                        break;
                                    case 2:
                                        Erabiltzaileak.erabiltzaileaGehitu(connection, teklatua);
                                        break;
                                    case 3:
                                        Erabiltzaileak.erabiltzaileakListatu(connection);
                                        break;
                                    case 4:
                                        Erabiltzaileak.erabiltzaileaEzabatu(connection, teklatua);
                                        break;
                                    default:
                                        System.out.println("Aukera baliogabea.");
                                }
                            }
                        default:
                            System.out.println("Ez daukazu baimenik honelako ekintzarik egiteko.");
                            return true;
                    }
                } else 
                {
                    System.out.println("Errorea: Erabiltzaile-izena edo pasahitza okerrak.");
                    saiakeraKop++;
                }
            } catch (SQLException e) 
            {
                e.printStackTrace();
                System.out.println("Errorea saioa hastean.");
            }
        }
        System.out.println("Akatsa: Hurrengo 15 segunduetan saioa berriro saioa hasteko saiatu.");
        try 
        {
            Thread.sleep(15000); // 15 segundu itxaron
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    // endregion

    /**
     * Metodo hau erabiltzaile bati haren notak ikusteko erabiltzen da.
     *
     * @param ikasleakNotakIkusi
     */

    public static void ikasleakNotakIkusi(Connection connection, Scanner teklatua, String erabiltzaileIzena) 
    {
        try 
        {
            String selectQuery = "SELECT * FROM notak WHERE zeinMatrikula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, erabiltzaileIzena);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Zure notak:");
            while (resultSet.next()) 
            {
                int zeinMatrikula = resultSet.getInt("zeinMatrikula");
                String ebaluaketa = resultSet.getString("ebaluaketa");
                int nota = resultSet.getInt("nota");
                String oharra = resultSet.getString("oharra");

                System.out.println("Matrikula: " + zeinMatrikula + ", Ebaluaketa: " + ebaluaketa +
                        ", Nota: " + nota + ", Oharra: " + oharra);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea notak ikustean.");
        }
    }
    // endregion

    /**
     * Metodo hau irakasle baten notak sartzeko erabiltzen da.
     *
     * @param irakasleakNotakSartu
     */

    public static void irakasleakNotakSartu(Connection connection, Scanner teklatua, String erabiltzaileIzena) 
    {
        try 
        {
            System.out.println("Zein matrikularen notak sartu nahi dituzu?");
            int matrikula = teklatua.nextInt();
            teklatua.nextLine();

            System.out.println("Ebaluaketa: ");
            String ebaluaketa = teklatua.nextLine();

            System.out.println("Nota: ");
            int nota = teklatua.nextInt();
            teklatua.nextLine();

            System.out.println("Oharra: ");
            String oharra = teklatua.nextLine();

<<<<<<< HEAD
            String insertQuery = "INSERT INTO notak (zeinMatrikula, ebaluaketa, nota, oharra) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, matrikula);
            preparedStatement.setString(2, ebaluaketa);
            preparedStatement.setInt(3, nota);
            preparedStatement.setString(4, oharra);
=======
            String insertSQL = "INSERT INTO notak " +
                    "(zeinMatrikula, ebaluaketa, nota, oharra ) " +
                    "VALUES (?, ?, ?, ?)";
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) 
            {
                System.out.println("Nota ongi sartu da.");
            } else 
            {
                System.out.println("Errorea nota sartzean.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea notak sartzeko.");
        }
    }
<<<<<<< HEAD

    public ikasleakNotakIkusi(String izena, String nota, )
    {
    }
}
=======
}
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e
