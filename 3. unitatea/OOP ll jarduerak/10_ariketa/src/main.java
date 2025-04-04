import java.util.ArrayList;
import java.util.Scanner;

public class main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        
        /**
         * Arraylist bat sortu kontuaren informazioa eta dirua gordetzeko
         */
        ArrayList<bankuKontua> kontuak = new ArrayList<bankuKontua>();

        kontuak.add(new bankuKontua("123456789", 1000, "asa"));

        System.out.println("Zer egin nahi duzu?");
        System.out.println("1. Dirua sartu");
        System.out.println("2. Dirua atera");
        System.out.println("3. Uneko diru kantitatea ikusi");
        System.out.println("4. Irten");

        int aukera = sc.nextInt();

        /**
         * Bukle bat non aukera 5 ez dan bitartean ez da geldituko
         */
        while (aukera != 4) 
        {
            switch (aukera) 
            {
                case 1:
                    System.out.println("\n" + "Zenbat diru sartu nahi duzu?");
                    double diruaSartu = sc.nextDouble();
                    kontuak.get(0).diruaSartu(diruaSartu);

                    break;
                case 2:
                    System.out.println("\n" + "Zenbat diru atera nahi duzu?");
                    double diruaAtera = sc.nextDouble();
                    kontuak.get(0).diruaAtera(diruaAtera);

                    break;
                case 3:
                    System.out.println("\n" + "Uneko diru kantitatea: " + kontuak.get(0).getSaldoa() + "\n");

                    break;
                default:
                    System.out.println("\n" + "Aukeratu duzun zenbakia ez da zuzena" + "\n");

                    break;
            }

            System.out.println("Zer egin nahi duzu?");
            System.out.println("1. Dirua sartu");
            System.out.println("2. Dirua atera");
            System.out.println("3. Uneko diru kantitatea ikusi");
            System.out.println("5. Irten");

            aukera = sc.nextInt();
        }
    }
}