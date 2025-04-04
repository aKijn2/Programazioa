public class bankuKontua 
{
    private String kontuZenbakia;
    private double saldoa;
    private String titularra;

    /**
     * Atribtuak
     * @param kontuZenbakia kontuaren zenbakia(idenrifikadorea)
     * @param saldoa gordeta den diru kantitatea
     * @param titularra kontuaren titularra
     */
    public bankuKontua(String kontuZenbakia, double saldoa, String titularra) 
    {
        this.kontuZenbakia = kontuZenbakia;
        this.saldoa = saldoa;
        this.titularra = titularra;
    }

    /**
     * Geterrak
     * @return kontuZenbakia
     * @return saldoa
     * @return titularra
     */
    public String getKontuZenbakia() 
    {
        return kontuZenbakia;
    }
    
    public double getSaldoa() 
    {
        return saldoa;
    }

    public String getTitularra() 
    {
        return titularra;
    }

    /**
     * Seterrak
     * @param kontuZenbakia 
     * @param saldoa
     * @param titularra
     */
    public void setKontuZenbakia(String kontuZenbakia) 
    {
        this.kontuZenbakia = kontuZenbakia;
    }

    public void setSaldoa(double saldoa) 
    {
        this.saldoa = saldoa;
    }

    public void setTitularra(String titularra) 
    {
        this.titularra = titularra;
    }

    /**
     * Dirua sartzeko metodoak
     * @param dirua guk sartu nahi dugun dirua
     */
    public void diruaSartu(double dirua) 
    {
        if (dirua > 0) 
        {
            saldoa += dirua;
            System.out.println("\n" + dirua + " euro sartu dira. Uneko saldoa: " + saldoa + "\n");
        } else 
        {
            System.out.println("\n" + "Ezin duzu dirua lapurtu..." + "\n");
        }
    }

    /**
     * Dirua sartzeko metodoak
     * @param dirua guk sartu nahi dugun dirua
     */
    public void diruaAtera(double dirua) 
    {
        if (dirua > 0 && dirua <= saldoa) 
        {
            saldoa -= dirua;
            System.out.println("\n" + dirua + " euro atera dira. Uneko saldoa: " + saldoa + "\n");
        } else 
        {
            System.out.println("\n" + "Ez duzu kantitate hori. Uneko saldoa: " + saldoa + "\n");
        }
    }
}