package com.erabiltzailea.ariketa;

public class Irakaslea extends Erabiltzailea 
{

    /**
     * Irakaslea klaseko objektuak.
     * @param nan
     * @param izena
     * @param abizena
     * @param erabiltzaileIzena
     * @param pasahitza
     */
    public Irakaslea(String nan, String izena, String abizena, String erabiltzaileIzena, String pasahitza) 
    {
        super(nan, izena, abizena, erabiltzaileIzena, pasahitza, "irakaslea");
    }

    /**
     * Irakaslearen ikasleen notak ikusteko metodoa.
     */
    public void notakSartu() 
    {
        // Ikasleei notak sartu
        System.out.println("Notak sartzeko sistema (DBra idatzi beharko da).");
    }
}
