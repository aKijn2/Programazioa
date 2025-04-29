package com.erabiltzailea.ariketa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Erabiltzaileak 
{

    public static void erabiltzaileaGehitu(Connection konexioa, Scanner teklatua) 
    {
        try 
        {
            System.out.println("Nan: ");
            String nan = teklatua.next();

            System.out.println("Izena: ");
            String izena = teklatua.next();

            System.out.println("Abizena: ");
            String erabizena = teklatua.next();

            System.out.println("Mota (ikaslea/irakaslea): ");
            String mota = teklatua.next();

            String erabiltzailea = izena.substring(0, 1).toLowerCase() + erabizena.toLowerCase();

            String erabBadago = "SELECT * FROM erabiltzaileak WHERE erabiltzailea = ?";

            PreparedStatement erabBadagoBalidatu = konexioa.prepareStatement(erabBadago);

            erabBadagoBalidatu.setString(1, erabiltzailea);

            ResultSet resultSet = erabBadagoBalidatu.executeQuery();

            if (resultSet.next()) 
            {
                int count = 1;
                while (resultSet.next()) 
                {
                    count++;
                }
                erabiltzailea = izena.substring(0, 1).toLowerCase() + erabizena.toLowerCase() + count;
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

            String datuakSartu = "INSERT INTO erabiltzaileak " +
                    "(erabiltzailea, erabizena, izena, mota, NA, pasahitza) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement datuakSartuObjetua = konexioa.prepareStatement(datuakSartu);

            datuakSartuObjetua.setString(1, erabiltzailea);
            datuakSartuObjetua.setString(2, erabizena);
            datuakSartuObjetua.setString(3, izena);
            datuakSartuObjetua.setString(4, mota);
            datuakSartuObjetua.setString(5, nan);
            datuakSartuObjetua.setString(6, pasahitza1);

            int erronkadak = datuakSartuObjetua.executeUpdate();

            if (erronkadak > 0) 
            {
                System.out.println("Erabiltzailea ongi gehitu da.");
            } else 
            {
                System.out.println("Errorea erabiltzailea gehitzean.");
            }

            erabiltzaileakListatu(konexioa);
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzailea gehitzean.");
        }
    }

    public static void erabiltzaileakListatu(Connection konexioa) 
    {
        try 
        {
            String selectQuery = "SELECT * FROM erabiltzaileak";
            PreparedStatement preparedStatement = konexioa.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Erabiltzaileak:");
            while (resultSet.next()) 
            {
                String nan = resultSet.getString("nan");
                String izena = resultSet.getString("izena");
                String erabizena = resultSet.getString("erabizena");
                String erabiltzailea = resultSet.getString("erabiltzailea");
                String mota = resultSet.getString("mota");

                System.out
                        .println("NAN: " + nan + ", Izena: " + izena + ", Erabizena: " + erabizena + ", Erabiltzailea: "
                                + erabiltzailea + ", Mota: " + mota);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzaileak listatzean.");
        }
    }

    public static void erabiltzaileaEzabatu(Connection konexioa, Scanner sc) 
    {
        try 
        {
            System.out.println("Sartu erabiltzailearen izena: ");
            String erabiltzailea = sc.next();

            String deleteQuery = "DELETE FROM erabiltzaileak WHERE erabiltzailea = ?";
            PreparedStatement preparedStatement = konexioa.prepareStatement(deleteQuery);

            preparedStatement.setString(1, erabiltzailea);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) 
            {
                System.out.println("Erabiltzailea ongi ezabatu da.");
            } else 
            {
                System.out.println("Errorea erabiltzailea ezabatzean. Erabiltzailea ez da aurkitu.");
            }

            erabiltzaileakListatu(konexioa);
        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea erabiltzailea ezabatzean.");
        }
    }

    public static boolean saioaHasi(Connection konexioa, Scanner sc) 
    {
        int saiakeraKop = 0;
        while (saiakeraKop < 3) 
        {
            try 
            {
                System.out.println("Erabiltzaile-izena: ");
                String erabiltzaileIzena = sc.nextLine();

                System.out.println("Pasahitza: ");
                String pasahitza = sc.nextLine();

                String selectQuery = "SELECT * FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";
                PreparedStatement preparedStatement = konexioa.prepareStatement(selectQuery);

                preparedStatement.setString(1, erabiltzaileIzena);
                preparedStatement.setString(2, pasahitza);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) 
                {
                    String izena = resultSet.getString("izena");
                    String erabizena = resultSet.getString("erabizena");
                    String mota = resultSet.getString("mota");

                    System.out.println("Saioa hasi da.");
                    System.out.println("Erabiltzailearen izena-erabizena: " + izena + " " + erabizena);
                    System.out.println("Mota: " + mota);

                    switch (mota) 
                    {
                        case "ikaslea":
                            while (true) 
                            {
                                System.out.println("\nAukeratu ekintza:");
                                System.out.println("1. Notak ikusi");
                                System.out.println("0. Irten");

                                int aukera = sc.nextInt();
                                sc.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.ikasleakNotakIkusi(konexioa, sc, erabiltzaileIzena);
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

                                int aukera = sc.nextInt();
                                sc.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.irakasleakNotakSartu(konexioa, sc, erabiltzaileIzena);
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

                                int aukera = sc.nextInt();
                                sc.nextLine();

                                switch (aukera) 
                                {
                                    case 0:
                                        System.out.println("Agur!");
                                        return true;
                                    case 1:
                                        Erabiltzaileak.sortuTaula(konexioa);
                                        System.out.println("Taula ongi sortu da.");
                                        break;
                                    case 2:
                                        Erabiltzaileak.erabiltzaileaGehitu(konexioa, sc);
                                        break;
                                    case 3:
                                        Erabiltzaileak.erabiltzaileakListatu(konexioa);
                                        break;
                                    case 4:
                                        Erabiltzaileak.erabiltzaileaEzabatu(konexioa, sc);
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
        System.out.println("Akatsa: Hurrengo 3 segunduetan saioa berriro saioa hasteko saiatu.");
        try 
        {
            Thread.sleep(3000); // 3 segundu itxaron
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    public static void ikasleakNotakIkusi(Connection konexioa, Scanner sc, String erabiltzaileIzena) 
    {
        try 
        {
            String selectQuery = "SELECT * FROM notak WHERE zeinMatrikula = ?";
            PreparedStatement preparedStatement = konexioa.prepareStatement(selectQuery);
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

    public static void irakasleakNotakSartu(Connection konexioa, Scanner sc, String erabiltzaileIzena) 
    {
        try 
        {
            System.out.println("Zein matrikularen notak sartu nahi dituzu?");
            int matrikula = sc.nextInt();
            sc.nextLine();

            System.out.println("Ebaluaketa: ");
            String ebaluaketa = sc.nextLine();

            System.out.println("Nota: ");
            int nota = sc.nextInt();
            sc.nextLine();

            System.out.println("Oharra: ");
            String oharra = sc.nextLine();

            String insertQuery = "INSERT INTO notak (zeinMatrikula, ebaluaketa, nota, oharra) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = konexioa.prepareStatement(insertQuery);
            preparedStatement.setInt(1, matrikula);
            preparedStatement.setString(2, ebaluaketa);
            preparedStatement.setInt(3, nota);
            preparedStatement.setString(4, oharra);

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

    public static void sortuTaula(Connection konexioa) 
    {
        try 
        {
            Statement statement = konexioa.createStatement();

            // Erabiltzaileak taula sortu
            String erabiltzaileakTable = "CREATE TABLE IF NOT EXISTS erabiltzaileak (" +
                    "erabiltzailea VARCHAR(50) PRIMARY KEY," +
                    "erabizena VARCHAR(50) NOT NULL," +
                    "izena VARCHAR(50) NOT NULL," +
                    "mota VARCHAR(20) NOT NULL," +
                    "NAN VARCHAR(20)," +
                    "pasahitza VARCHAR(100) NOT NULL" +
                    ")";
            statement.executeUpdate(erabiltzaileakTable);

            // Ikasgaiak taula sortu
            String ikasgaiakTable = "CREATE TABLE IF NOT EXISTS ikasgaiak (" +
                    "kodea VARCHAR(50) PRIMARY KEY," +
                    "izena VARCHAR(100) NOT NULL," +
                    "zeinTalde VARCHAR(50)" +
                    ")";
            statement.executeUpdate(ikasgaiakTable);

            // Zikloak taula sortu (lehenago sortu behar da)
            String zikloakTable = "CREATE TABLE IF NOT EXISTS zikloak (" +
                    "idZikloa VARCHAR(50) PRIMARY KEY," +
                    "izena VARCHAR(100) NOT NULL," +
                    "familia VARCHAR(100) NOT NULL," +
                    "maila VARCHAR(50) NOT NULL" +
                    ")";
            statement.executeUpdate(zikloakTable);

            // Taldeak taula sortu (zikloak taulari erreferentzia egiten dio)
            String taldeakTable = "CREATE TABLE IF NOT EXISTS taldeak (" +
                    "idTaldea VARCHAR(50) PRIMARY KEY," +
                    "zeinZiklo VARCHAR(50) NOT NULL," +
                    "zeinTutore VARCHAR(50)," +
                    "FOREIGN KEY (zeinZiklo) REFERENCES zikloak(idZikloa)," +
                    "FOREIGN KEY (zeinTutore) REFERENCES erabiltzaileak(erabiltzailea)" +
                    ")";
            statement.executeUpdate(taldeakTable);

            // Irakasle_irakats taula sortu
            String irakasleIrakatsTable = "CREATE TABLE IF NOT EXISTS irakasle_irakats (" +
                    "zeinIrakasle VARCHAR(50) NOT NULL," +
                    "zeinIkasgai VARCHAR(50) NOT NULL," +
                    "FOREIGN KEY (zeinIrakasle) REFERENCES erabiltzaileak(erabiltzailea)," +
                    "FOREIGN KEY (zeinIkasgai) REFERENCES ikasgaiak(kodea)," +
                    "PRIMARY KEY (zeinIrakasle, zeinIkasgai)" +
                    ")";
            statement.executeUpdate(irakasleIrakatsTable);

            // Matrikulak taula sortu
            String matrikulakTable = "CREATE TABLE IF NOT EXISTS matrikulak (" +
                    "idMatrikula INT AUTO_INCREMENT PRIMARY KEY," +
                    "zeinIkasgai VARCHAR(50) NOT NULL," +
                    "zeinIkasle VARCHAR(50) NOT NULL," +
                    "FOREIGN KEY (zeinIkasgai) REFERENCES ikasgaiak(kodea)," +
                    "FOREIGN KEY (zeinIkasle) REFERENCES erabiltzaileak(erabiltzailea)" +
                    ")";
            statement.executeUpdate(matrikulakTable);

            // Notak taula sortu
            String notakTable = "CREATE TABLE IF NOT EXISTS notak (" +
                    "idNota INT AUTO_INCREMENT PRIMARY KEY," +
                    "zeinMatrikula INT NOT NULL," +
                    "ebaluaketa VARCHAR(50) NOT NULL," +
                    "nota INT NOT NULL," +
                    "oharra VARCHAR(255)," +
                    "FOREIGN KEY (zeinMatrikula) REFERENCES matrikulak(idMatrikula)" +
                    ")";
            statement.executeUpdate(notakTable);

            System.out.println("Taulak ongi sortu dira (edo lehendik bazeuden).");

        } catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Errorea taulak sortzean.");
        }
    }

}
