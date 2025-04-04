import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {

        ArrayList<Integer> lista = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int zenbakia;

        /**
         * Zenbakiak sartu eta -1 sartu arte
         */
        System.out.println("Sartu balio bat eta -1 jarri bukatu baldin baduzu zenbakiak sartzeas:");
        while ((zenbakia = scanner.nextInt()) != -1) 
        {
            lista.add(zenbakia);
        }

        System.out.println(lista);
        scanner.close();
    }
}
