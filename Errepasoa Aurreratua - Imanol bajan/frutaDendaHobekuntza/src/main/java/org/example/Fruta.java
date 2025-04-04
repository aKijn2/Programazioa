package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Fruta
{
    /**
     * frutaren izena (adb: limoia)
     */
    @JsonProperty("izena")
    String izena;
    /**
     * irudiaren helbide erlatiboa (.jpg)
     */
    @JsonProperty("irudia")
    String irudia;
    /**
     * frutaren prezioa kg-ko
     */
    @JsonProperty("prezioa")
    double prezioa;
    /**
     * zenbat kg ditugun dendan
     */
    @JsonProperty("stock")
    int stock;

    /**
     *  Sortzailea
     * @param izena Frutaren izen laburra ("limoia")
     * @param irudia Frutaren irudiaren helbide erlatiboa (proiektua oinarri hartuta)
     * @param prezioa
     * @param stock
     */
    @JsonCreator
    public Fruta(@JsonProperty("izena") String izena,
                 @JsonProperty("irudia") String irudia,
                 @JsonProperty("prezioa") double prezioa,
                 @JsonProperty("stock") int stock)
    {
        this.izena 		= izena;
        this.irudia 	= irudia;
        this.prezioa 	= prezioa;
        this.stock 		= stock;
    }

    // Metodoak
    public String getIzena() {
        return izena;
    }

    public String getIrudia() {
        return irudia;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public int getStock() {
        return stock;
    }

    // Settera
    public void setStock(int i) {
        this.stock = i;
    }
}