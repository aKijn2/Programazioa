package com.erabiltzailea.ariketa;

public class Tutorea extends Erabiltzailea 
{

    /**
     * Tutorea klaseko objektuak.
     * @param nan
     * @param izena
     * @param abizena
     * @param erabiltzaileIzena
     * @param pasahitza
     */
    public Tutorea(String nan, String izena, String abizena, String erabiltzaileIzena, String pasahitza) 
    {
        super(nan, izena, abizena, erabiltzaileIzena, pasahitza, "tutorea");
    }

    /**
     * Tutorearen ikasleen notak ikusteko metodoa.
     * Ikasleen notak datu basean ikusi ahal izateko.
     */
    public void tutoretzaNotakIkusi() 
    {
        // Datu basetik bere ikasleen notak atera
        System.out.println("Zure tutoretzako ikasleen notak: (DBtik aterako dira hemen)");
    }
}
