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
                default:
                    System.out.println("Aukera ez egokia.");
            }
        }
        teklatua.close();
    }
}
