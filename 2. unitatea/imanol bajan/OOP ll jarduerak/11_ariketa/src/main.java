public class main
{
    public static void main(String[] args) throws Exception
    {
        zatikiak zatikiak1 = new zatikiak(1, 2);
        zatikiak zatikiak2 = new zatikiak(3, 4);
        zatikiak zatikiak3 = new zatikiak(12, 6);


        zatikiak1.batura(zatikiak3);

        System.out.println(zatikiak1.getZatidura() + "/" + zatikiak1.getZatzailea());

        zatikiak2.biderkadura(zatikiak1);

        System.out.println(zatikiak2.getZatidura() + "/" + zatikiak2.getZatzailea());

        zatikiak3.biderkadura(zatikiak1);

        System.out.println(zatikiak1.getZatidura() + "/" + zatikiak3.getZatzailea());
    }
}

