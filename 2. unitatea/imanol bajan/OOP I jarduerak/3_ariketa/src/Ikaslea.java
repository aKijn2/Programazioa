import java.util.ArrayList;

public class Ikaslea 
{
    private String izena;
    private ArrayList<Double> notak;

    // Konstruktorea
    public Ikaslea(String izena) 
    {
        this.izena = izena;
        this.notak = new ArrayList<>();
    }

    // Geterrak
    public String getIzena() 
    {
        return izena;
    }

    public ArrayList<Double> getNotak() 
    {
        return notak;
    }

    // Seterrak
    public void gehituNota(double nota) 
    {
        notak.add(nota);
    }

    // Metodoak
    public double kalkulatuBatazBestekoa() 
    {
        if (notak.isEmpty()) 
        {
            return 0;
        }

        double eragiketa = 0;

        for (double nota : notak) 
        {
            eragiketa += nota;
        }
        return eragiketa / notak.size();
    }

    @Override
    public String toString() 
    {
        return "Ikaslea{" +
                "izena='" + izena + '\'' +
                ", notak=" + notak +
                ", bataz-bestekoa=" + kalkulatuBatazBestekoa() +
                '}';
    }
}