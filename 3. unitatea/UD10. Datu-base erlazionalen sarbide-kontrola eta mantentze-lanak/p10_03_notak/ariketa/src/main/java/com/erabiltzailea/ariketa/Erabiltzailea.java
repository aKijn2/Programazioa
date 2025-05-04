package com.erabiltzailea.ariketa;

public class Erabiltzailea 
{
    private String nan;
    private String izena;
    private String abizena;
    private String erabiltzaileIzena;
    private String pasahitza;
    private String mota; 

    /**
     * Erabiltzailea klaseko objektuak.
     * @param nan 
     * @param izena
     * @param abizena
     * @param erabiltzaileIzena
     * @param pasahitza
     * @param mota
     */
    public Erabiltzailea(String nan, String izena, String abizena, String erabiltzaileIzena, String pasahitza, String mota) 
    {
        this.nan                = nan;
        this.izena              = izena;
        this.abizena            = abizena;
        this.erabiltzaileIzena  = erabiltzaileIzena;
        this.pasahitza          = pasahitza;
        this.mota               = mota;
    }

    /**
     * Datuak irakurri eta itzultzen ditu.
     * @return Nan-a, izena, abizena, erabiltzaile izena, pasahitza eta mota irakurri eta itzultzen ditu.
     */
    public String getNan()                  { return nan; }
    public String getIzena()                { return izena; }
    public String getAbizena()              { return abizena; }
    public String getErabiltzaileIzena()    { return erabiltzaileIzena; }
    public String getPasahitza()            { return pasahitza; }
    public String getMota()                 { return mota; }
}
