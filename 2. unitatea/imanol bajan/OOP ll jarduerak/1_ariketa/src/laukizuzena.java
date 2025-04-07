public class laukizuzena 
{
    private double luzeera;
    private double zabalera;

    public laukizuzena(double luzeera, double zabalera) 
    {
        this.luzeera = luzeera;
        this.zabalera = zabalera;
    }

    /**
     * Geterrak
     * 
     * @return luzeera
     * @return zabalera
     */
    public double getLuzeera() 
    {
        return luzeera;
    }

    public double getZabalera() 
    {
        return zabalera;
    }

    /**
     * Seterrak
     * 
     * @param luzeera
     * @param zabalera
     */
    public void setLuzeera(double luzeera) 
    {
        this.luzeera = luzeera;
    }

    public void setZabalera(double zabalera) 
    {
        this.zabalera = zabalera;
    }

    /**
     * Azalera kalkulatzeko metodoa
     */

     public double azaleraKalkulatu()
     {
         return luzeera * zabalera;
     }
}
