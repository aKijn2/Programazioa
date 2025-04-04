public class zatikiak 
{
    
    private int zatidura;
    private int zatzailea;

    /**
     * Eraikitzaileak
     * 
     * @param zatidura
     * @param zatzailea
     */
    public zatikiak(int zatidura, int zatzailea) 
    {
        this.zatidura = zatidura;
        this.zatzailea = zatzailea;
    }

    /**
     * Seterrak
     * @param zatidura
     */
    public void setZatidura(int zatidura) 
    {
        this.zatidura = zatidura;
    }

    /**
     * Seterrak
     * @param zatzailea
     */
    public void setZatzailea(int zatzailea)
    {
        this.zatzailea = zatzailea;
    }

    /**
     * Geterrak
     * @return zatzailea vueltatuko digu
     */
    public int getZatidura() 
    {
        return zatidura;
    }

    /**
     * Geterrak
     * @return zatzailea vueltatuko digu
     */
    public int getZatzailea()
    {
        return zatzailea;
    }

    /**
     * Metodo hau zatikiak batzeko erabiliko da
     * @param zatikiak 
     */
     public void batura(zatikiak zatikiak) 
     {
         this.zatidura = this.zatidura + zatikiak.getZatidura();
         this.zatzailea = this.zatzailea + zatikiak.getZatzailea();
     }

    /**
     * Metodo hau zatikiak biderkatzeko erabiliko da
     * @param zatikiak 
     */
    public void biderkadura(zatikiak zatikiak) 
    {
        this.zatidura = this.zatidura * zatikiak.getZatidura();
        this.zatzailea = this.zatzailea * zatikiak.getZatzailea();
    }

    /**
     * Metodo hau zatikiak simplifikatzeko erabiliko da
     * @param zatikiak 
     */
    public void sinplifikatu(zatikiak zatikiak) 
    {
        this.zatidura = this.zatidura / zatikiak.getZatidura();
        this.zatzailea = this.zatzailea / zatikiak.getZatzailea();
    }
    

}
