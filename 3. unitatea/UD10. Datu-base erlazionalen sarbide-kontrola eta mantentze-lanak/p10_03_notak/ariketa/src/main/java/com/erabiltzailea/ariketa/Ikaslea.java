package com.erabiltzailea.ariketa;

public class Ikaslea extends Erabiltzailea 
{

    /**
     * Ikaslea klaseko objektuak.
     * @param nan
     * @param izena
     * @param abizena
     * @param erabiltzaileIzena
     * @param pasahitza
     */
    public Ikaslea(String nan, String izena, String abizena, String erabiltzaileIzena, String pasahitza) 
    {
        super(nan, izena, abizena, erabiltzaileIzena, pasahitza, "ikaslea");
    }

    /**
     * Ikaslearen notak ikusteko metodoa.
     * Ikaslearen notak datu basean ikusi ahal izateko.
     */
    public void notakIkusi() 
    {
        // Datu basetik ikaslearen notak atera
        System.out.println("Zure notak: (DBtik aterako dira hemen)");
    }
}
