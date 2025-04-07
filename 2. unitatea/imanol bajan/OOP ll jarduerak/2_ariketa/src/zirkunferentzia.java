public class zirkunferentzia 
{
    private int erradioa;

    /**
     * Zirkunferentzia klasearen konstruktorea
     * 
     * @param erradioa Zirkunferentziaren erradioa
     */
    public zirkunferentzia(int erradioa) 
    {
        this.erradioa = erradioa;
    }

    /**
     * Erradioaren geterra
     * 
     * @return erradioa Zirkunferentziaren erradioa vueltatuko digi
     */
    public int getErradioa() 
    {
        return erradioa;
    }

    /**
     * Metodoak
     */

    /**
     * Zirkunferentziaren azalera kalkulatzen duen metodoa
     * 
     * @return
     */
    public double azaleraKalkulatu() 
    {
        return Math.PI * Math.pow(erradioa, 2);
    }

    /**
     * Zirkunferentziaren perimetroa kalkulatzen duen metodoa
     * 
     * @return
     */
    public double perimetroaKalkulatu() 
    {
        return 2 * Math.PI * erradioa;
    }
}