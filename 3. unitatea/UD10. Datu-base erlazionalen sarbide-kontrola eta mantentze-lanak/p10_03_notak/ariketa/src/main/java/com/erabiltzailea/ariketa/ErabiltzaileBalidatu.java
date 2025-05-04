package com.erabiltzailea.ariketa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ErabiltzaileBalidatu 
{
    /**
     * Erabiltzaile izena existitzen den ala ez egiaztatzen du.
     * 
     * @param Konexioa Datu-basearen konexioa 
     * @param erabiltzaileIzena
     * @return true erabiltzaile izena existitzen bada, false bestela
     * @throws Exception 
     */
    public static boolean erabiltzaileaExistitzenDa(Connection Konexioa, String erabiltzaileIzena) throws Exception 
    {
        String sql = "SELECT COUNT(*) FROM erabiltzaileak WHERE erabiltzailea = ?";
        PreparedStatement st = Konexioa.prepareStatement(sql);
        st.setString(1, erabiltzaileIzena);
        ResultSet rs = st.executeQuery();

        if (rs.next())
            return rs.getInt(1) > 0;
        return false;
    }

    /**
     * Efrabiltzailea sortzen du izena eta abizenaren arabera.
     * 
     * @param Konexioa Datu-basearen konexioa
     * @param izena 
     * @param abizena 
     * @return Erabiltzaile izena
     * @throws Exception
     */
    public static String sortuErabiltzaileIzena(Connection Konexioa, String izena, String abizena) throws Exception 
    {
        String base = izena.substring(0, 1).toLowerCase() + abizena.toLowerCase();
        String erabiltzaileIzena = base;

        int i = 1;

        while (erabiltzaileaExistitzenDa(Konexioa, erabiltzaileIzena)) 
        {
            if (i < izena.length()) 
            {
                erabiltzaileIzena = izena.substring(0, i + 1).toLowerCase() + abizena.toLowerCase();
            } else 
            {
                erabiltzaileIzena = base + String.format("%02d", i - izena.length() + 1);
            }
            i++;
        }
        return erabiltzaileIzena;
    }
}
