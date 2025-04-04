public class Fruta
{
    /**
     * frutaren izena (adb: limoia)
     */
    String izena;
    /**
     * irudiaren helbide erlatiboa (.jpg)
     */
    String irudia;
    /**
     * frutaren prezioa kg-ko
     */
    double prezioa;
    /**
     * zenbat kg ditugun dendan
     */
    int stock;

    /**
     *  Sortzailea
     * @param izena Frutaren izen laburra ("limoia"
     * @param irudia Frutaren irudiaren helbide erlatiboa (proiektua oinarri hartuta)
     * @param prezioa
     * @param stock
     */
    public Fruta(String izena, String irudia, double prezioa, int stock)
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
