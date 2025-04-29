package com.p10_notak;

import java.sql.Connection;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {
        Konexioa konexioa = new Konexioa();
        Connection kone = konexioa.konektatu_db();

        if (kone == null) 
        {
            System.out.println("Ez da datu-basearekin konektatu.");
            return;
        }

        NotenKudeaketa nk = new NotenKudeaketa(kone);
        Scanner teklatua = new Scanner(System.in);

<<<<<<< HEAD
        int saioaHasi = -1;

        while (saioaHasi != 0) 
        {
            System.out.println("=================================================");
            System.out.println("Mesedez, aukeratu ekintza:                       ");
            System.out.println("1. Saioa hasi                                    ");
            System.out.println("2. Erabiltzaile berria sortu                     ");
            System.out.println("0. Irten                                         ");
            System.out.println("=================================================");
            System.out.print("Aukeratu zenbakia: ");

            saioaHasi = teklatua.nextInt();
            teklatua.nextLine();

            switch (saioaHasi) 
            {
                case 1:
                    // Aldaketa hemen: array bat itzultzen du
                    String saioInfo = nk.saioaHasi(); // erabiltzaile mota edo izena
                    if (saioInfo != null) 
                    {
                        // Hemen, saioInfo-ren erabilera egokitu behar duzu zure saioaHasi() metodoaren
                        // itzulera motaren arabera.
                        // Adibidez, erabiltzaile mota itzultzen badu:
                        String erabiltzaileMota = saioInfo;
                        if ("ikaslea".equals(erabiltzaileMota)) 
                        {
                            // Izena lortu behar baduzu, beste metodo bat erabil ezazu edo saioaHasi()
                            // egokitu
                            System.out.print("Sartu zure izena: ");
                            String erabiltzaileIzena = teklatua.nextLine();
                            ikaslearenMenua(nk, teklatua, erabiltzaileIzena);
                        } else if ("irakaslea".equals(erabiltzaileMota)) 
                        {
                            System.out.print("Sartu zure izena: ");
                            String erabiltzaileIzena = teklatua.nextLine();
                            irakaslearenMenua(nk, teklatua, erabiltzaileIzena);
                        } else 
                        {
                            System.out.println("Saioa hasteko errorea.");
                        }
                    } else 
                    {
                        System.out.println("Saioa hasteko errorea.");
                    }
                    break;

                case 2:
                    nk.erabiltzaileaSortu();
                    break;

                case 0:
                    System.out.println("Programatik irteten...");
                    break;

=======
        int aukera = 0;

        while (aukera != 4)
        {
            System.out.println("=================================================");
            System.out.println("Mesedez, aukeratu ekintza:");
            System.out.println("1. Erabiltzaile berria sortu");
            System.out.println("2. Saioa hasi");
            System.out.println("3. Notak kudeatu (ikasle/irakasle/tutore)");
            System.out.println("4. Irten");
            System.out.println("=================================================");
            System.out.print("Aukeratu zenbakia: ");
            
            aukera = teklatua.nextInt();
            teklatua.nextLine();

            switch (aukera) 
            {
                case 1:
                    nk.erabiltzaileaSortu();
                    break;
                case 2:
                    nk.saioaHasi();
                    break;
                case 3:
                    System.out.print("Sartu erabiltzaile izena: ");
                    String erabiltzaileIzena = teklatua.nextLine();
                    nk.menuNotak(erabiltzaileIzena);
                    break;
                case 4:
                    System.out.println("Agur!");
                    break;
>>>>>>> 079c1521f96fccb9f6c91a404fb56f0b5abb0a4e
                default:
                    System.out.println("Aukera ez egokia.");
            }
        }

        teklatua.close();
    }

    // Ikaslearen menua: erabiltzaileIzena parametro gisa
    private static void ikaslearenMenua(NotenKudeaketa nk, Scanner teklatua, String erabiltzaileIzena) 
    {
        int ikaslea = -1;

        while (ikaslea != 0) 
        {
            System.out.println("=================================================");
            System.out.println("Mesedez, aukeratu ekintza:                       ");
            System.out.println("1. Notak ikusi                                   ");
            System.out.println("0. Irten                                         ");
            System.out.println("=================================================");
            System.out.print("Aukeratu zenbakia: ");

            ikaslea = teklatua.nextInt();
            teklatua.nextLine();

            switch (ikaslea) 
            {
                case 1:
                    // Ez galdetu berriro izena, zuzenean pasatu
                    nk.erakutsiNotakIkaslea(erabiltzaileIzena);
                    break;

                case 0:
                    System.out.println("Programatik irteten...");
                    break;

                default:
                    System.out.println("Aukera ez egokia.");
            }
        }
    }

    // Irakaslearen menua: erabiltzaileIzena parametro gisa (baina beste baten izena
    // sartu dezake)
    private static void irakaslearenMenua(NotenKudeaketa nk, Scanner teklatua, String erabiltzaileIzena) 
    {
        int irakaslea = -1;

        while (irakaslea != 0) 
        {
            System.out.println("=================================================");
            System.out.println("Mesedez, aukeratu ekintza:                       ");
            System.out.println("1. Notak kudeatu                                 ");
            System.out.println("2. Ikasle berir bat matrikuatu                   ");
            System.out.println("0. Irten                                         ");
            System.out.println("=================================================");
            System.out.print("Aukeratu zenbakia: ");

            irakaslea = teklatua.nextInt();
            teklatua.nextLine();

            switch (irakaslea) 
            {
                case 1:
                    System.out.print("Sartu ikaslearen izena: ");
                    String ikasleIzena = teklatua.nextLine();
                    nk.menuNotak(ikasleIzena);
                    break;

                case 2:
                    nk.ikasleakMatrikulatu();
                    break;

                case 0:
                    System.out.println("Programatik irteten...");
                    break;

                default:
                    System.out.println("Aukera ez egokia.");
            }
        }
    }
}