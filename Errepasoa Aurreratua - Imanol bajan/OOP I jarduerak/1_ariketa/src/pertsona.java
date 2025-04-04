public class pertsona 
{
    private String izena;
    private int adina;

    // Eraikitzailea
    public pertsona(String izena, int adina) 
    {
        this.izena = izena;
        this.adina = adina;
    }

    // Geterrak
    public String getIzena() 
    {
        return izena;
    }

    // Seterrak
    public int getAdina() 
    {
        return adina;
    }
}