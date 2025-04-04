import java.util.Scanner;

public class main 
{
    public static void main(String[] args) throws Exception 
    {

        Scanner sc = new Scanner(System.in);
        
        /**
         * Luzeera eta azaleraren datuak sartu
         */
        System.out.println("Sartu laukizuzenaren luzeera: ");
        double luzeera = sc.nextInt();

        System.out.println("Sartu laukizuzenaren zabalera: ");
        double zabalera = sc.nextInt();

        laukizuzena laukizuzena = new laukizuzena(luzeera, zabalera);

        /**
         * Azalera kalkulatu
         */
        System.out.println("Laukizuzenaren azalera: " + laukizuzena.azaleraKalkulatu());
    }
}
