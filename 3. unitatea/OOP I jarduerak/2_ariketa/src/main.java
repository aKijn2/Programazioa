import java.util.ArrayList;
import java.util.Scanner;

public class main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Autoa> autolista = new ArrayList<>();

        // Auto batzuk gehitu
        autolista.add(new Autoa(15000, "Toyota", "Corolla"));
        autolista.add(new Autoa(20000, "Honda", "Civic"));
        autolista.add(new Autoa(12000, "Ford", "Fiesta"));
        autolista.add(new Autoa(30000, "BMW", "Serie 3"));

        System.out.print("Sartu prezio bat (bajuago erakusteko): ");
        double mugaPrezioa = scanner.nextDouble();

        // Prezioa baino bajuagoak diren autoak inprimatu
        System.out.println("Prezioa " + mugaPrezioa + " baino bajuagoak diren autoak:");

        for (Autoa autoa : autolista) 
        {
            if (autoa.getPrezioa() <= mugaPrezioa) 
            {
                System.out.println(autoa);
            }
        }
    }
}