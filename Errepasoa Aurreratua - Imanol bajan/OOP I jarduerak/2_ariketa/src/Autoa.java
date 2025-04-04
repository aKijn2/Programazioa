
public class Autoa 
{
    private double prezioa;
    private String marka;
    private String modeloa;

    // Konstruktorea
    public Autoa(double prezioa, String marka, String modeloa) 
    {
        this.prezioa = prezioa;
        this.marka = marka;
        this.modeloa = modeloa;
    }

    // Getterrak
    public double getPrezioa() 
    {
        return prezioa;
    }

    public String getMarka() 
    {
        return marka;
    }

    public String getModeloa() 
    {
        return modeloa;
    }

    // Metodoak
    @Override
    public String toString() 
    {
        return "Autoa{" +
                "prezioa=" + prezioa +
                ", marka='" + marka + '\'' +
                ", moledoa='" + modeloa + '\'' +
                '}';
    }
}