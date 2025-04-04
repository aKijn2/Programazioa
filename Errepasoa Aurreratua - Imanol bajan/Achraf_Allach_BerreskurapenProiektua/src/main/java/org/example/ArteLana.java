package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArteLana
{
    /**
     * Arte lanaren atributuak.
     */
    @JsonProperty("izenburua")
    private final String izenburua;

    @JsonProperty("artista")
    private final String artista;

    @JsonProperty("tamaina")
    private final String tamaina;

    @JsonProperty("estiloa")
    private final String estiloa;

    @JsonProperty("mota")
    private final String mota;

    @JsonProperty("prezioa")
    private final double prezioa;

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
    public ArteLana(String izenburua, String artista, String tamaina, String estiloa, String mota, double prezioa) 
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
        System.out.println("");
        System.out.println("Izenburua: "    + izenburua);
        System.out.println("Artista: "      + artista);
        System.out.println("Tamaina: "      + tamaina);
        System.out.println("Estiloa: "      + estiloa);
        System.out.println("Mota: "         + mota);
        System.out.printf("Prezioa:"        + prezioa);
        System.out.println("");
    }
}