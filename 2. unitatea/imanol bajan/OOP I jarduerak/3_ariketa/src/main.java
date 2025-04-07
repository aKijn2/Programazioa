public class main 
{
    public static void main(String[] args) 
    {
        Ikaslea ikaslea = new Ikaslea("Jon");

        // Notak gehitu
        ikaslea.gehituNota(8.5);
        ikaslea.gehituNota(7.0);
        ikaslea.gehituNota(9.0);

        // Ikaslearen informazioa inprimatu
        System.out.println(ikaslea);
    }
}