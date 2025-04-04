package org.proiektua;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArteLana
{
    /**
     * Arte lanaren atributuak.
     */
    @JsonProperty("izenburua")
    String izenburua;

    @JsonProperty("artista")
    String artista;

    @JsonProperty("tamaina")
    String tamaina;

    @JsonProperty("estiloa")
    String estiloa;

    @JsonProperty("mota")
    String mota;
    
    @JsonProperty("prezioa")
    double prezioa;

    /**
     * ArteLana objektu bat eraikitzen du.
     * 
     * @param izenburua     Arte lanaren izenburua
     * @param artista       Arte lanaren egilea
     * @param tamaina       Dimentsia (adib., "20x20 hazbeteko")
     * @param estiloa       Arte estiloa (adib., "Modernoa", "Abstraktua")
     * @param mota          Arte lan mota (adib., "Margolana", "Eskultura")
     * @param prezioa       Arte lanaren prezioa
     */
    @JsonCreator
    public ArteLana
    (
        @JsonProperty("izenburua")      String izenburua, 
        @JsonProperty("artista")        String artista, 
        @JsonProperty("tamaina")        String tamaina, 
        @JsonProperty("estiloa")        String estiloa, 
        @JsonProperty("mota")           String mota, 
        @JsonProperty("prezioa")        double prezioa
    ) 
    
    {
        this.izenburua      = izenburua;
        this.artista        = artista;
        this.tamaina        = tamaina;
        this.estiloa        = estiloa;
        this.mota           = mota;
        this.prezioa        = prezioa;
    }

    // Getterrak
    public String getIzenburua()    { return izenburua; }
    public String getArtista()      { return artista; }
    public String getTamaina()      { return tamaina; }
    public String getEstiloa()      { return estiloa; }
    public String getMota()         { return mota; }
    public double getPrezioa()      { return prezioa; }

    /**
     * Arte nlanaren datuak imprimatu konsolan.
     */
    public void imprimatuDatuak() 
    {
        System.out.printf("|%-10s|%-6s|%-7s|%-7s|%-4s|%-7.2f|\n", izenburua, artista, tamaina, estiloa, mota, prezioa);
        System.out.println("|----------------------------------------------|");
    }
}