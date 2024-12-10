import java.io.*;
import java.util.*;

public class Fitxategia1 {

    public static void main(String args[]) {

        String fitxIzena;

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Fitxategiaren izena eta bere helbide absolutua sartu: ");

            fitxIzena = sc.nextLine();

            File f = new File(fitxIzena);

            System.out.println("Izena" + f.getName());

            System.out.println("Helbidea: " + f.getPath());

            if (f.exists())

            {

                System.out.println("Fitxategia badago ");

                if (f.canRead()) {

                    System.out.println("Irakur daiteke");

                }

                if (f.canWrite()) {

                    System.out.println("Idatz daiteke");

                }

                System.out.println("Fitxategiaren tamaiana:" + f.length() + " byte dira");

            } else {

                System.out.println("EZ da fitxategia existitzen.");

            }

        }

        catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
