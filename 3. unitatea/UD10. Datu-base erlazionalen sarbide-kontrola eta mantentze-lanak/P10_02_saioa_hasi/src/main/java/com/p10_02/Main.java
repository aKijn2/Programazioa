package main.java.com.p10_02;

import java.sql.Connection;

public class Main 
{
    public static void main(String[] args) 
    {
        try (Connection conn = Konexioa.konektatu()) 
        {
            System.out.println("DB konektatuta.");
            ErabiltzaileKudeaketa serv = new ErabiltzaileKudeaketa();
            serv.exekutatuMenua(conn);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
