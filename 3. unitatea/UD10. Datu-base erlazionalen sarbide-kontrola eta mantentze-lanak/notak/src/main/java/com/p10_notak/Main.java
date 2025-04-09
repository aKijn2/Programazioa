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
            System.out.println("Ez da datubasearekin konektatu.");
            return;
        }

        NotenKudeaketa nk = new NotenKudeaketa(kone);
        Scanner teklatua = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("Mesedez, aukeratu zure rolaren araberako ekintza:");
        System.out.println("1. Ikasleak: bere notak ikusi");
        System.out.println("2. Irakasleak: nota bat sartu");
        System.out.println("3. Tutoreak: bere ikasleen notak ikusi");
        System.out.println("====================================");
        System.out.print("Aukeratu zenbakia: ");
        int aukera = teklatua.nextInt();
        teklatua.nextLine();

        switch (aukera) 
        {
            case 1:
                System.out.print("Sartu ikaslearen erabiltzaile izena: ");
                String ikasleErab = teklatua.nextLine();
                nk.erakutsiNotakIkaslea(ikasleErab);
                break;
            case 2:
                System.out.print("Sartu irakaslearen erabiltzaile izena: ");
                String irakasleErab = teklatua.nextLine();
                nk.sartuNota(irakasleErab);
                break;
            case 3:
                System.out.print("Sartu tutorearen erabiltzaile izena: ");
                String tutoreErab = teklatua.nextLine();
                nk.erakutsiTutoreNotak(tutoreErab);
                break;
            default:
                System.out.println("Aukera ez egokia. Mesedez, sartu 1, 2 edo 3.");
                break;
        }
        teklatua.close();
    }
}
