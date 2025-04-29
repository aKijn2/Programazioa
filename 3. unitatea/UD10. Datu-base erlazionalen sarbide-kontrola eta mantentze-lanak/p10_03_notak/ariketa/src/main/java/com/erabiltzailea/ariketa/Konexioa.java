package com.erabiltzailea.ariketa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa 
{

    /**
     * Metodo honek konexioa sortzen du datu-basearekin.
     * 
     * @return Konexio objektua
     * @throws SQLException Konexioaren errorea
     */
    public Connection getKonekzioa() throws SQLException 
    {
        String DB_URL = "jdbc:mysql://localhost/erabiltzaileak";
        String USER = "root";
        String PASS = "mysql";

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        return connection;
    }
}
