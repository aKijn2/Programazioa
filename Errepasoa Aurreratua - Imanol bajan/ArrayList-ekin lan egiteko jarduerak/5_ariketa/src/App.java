import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {

        Scanner sc = new Scanner(System.in);

        /**
         * Arraylist bat sortuko du
         */
        ArrayList<Integer> zenbakiak = new ArrayList<>();

        /**
         * Bost zenbaki geitzen dugu
         */
        zenbakiak.add(1);
        zenbakiak.add(2);
        zenbakiak.add(3);
        zenbakiak.add(4);
        zenbakiak.add(5);

        /**
         * Arraylist osoa erakutsiko du
         */
        System.out.println("Sartu zembaki bat: ");
        int bilatu = sc.nextInt();

        if (zenbakiak.contains(bilatu)) 
        {
            System.out.println("badago");
        } else 
        {
            System.out.println("ez dago");
        }
    }
}
