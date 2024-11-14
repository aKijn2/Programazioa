import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Datuak sartzeko
        System.out.println("Sartu pertsonaren izena:");
        String izena = sc.nextLine();

        System.out.println("Sartu pertsonaren adina:");
        int adina = sc.nextInt();

        System.out.println("Sartu pertsonaren sexua (G/E):");
        String sexua = sc.next();

        System.out.println("Sartu pertsonaren pisua:");
        float pisua = sc.nextFloat();

        System.out.println("Sartu pertsonaren altuera:");
        float altuera = sc.nextFloat();

        // Pertsona objektua sortu
        Pertsona pertsona = new Pertsona(izena, adina, sexua.charAt(0), pisua, altuera);

        // Pertsonaren informazioa pantailatik ateratzeko
        System.out.println("Pertsonaren informazioa:");

        System.out.println("Izena: " + pertsona.getIzena());
        System.out.println("Adina: " + pertsona.getAdina());
        System.out.println("Sexua: " + pertsona.getSexua());
        System.out.println("Sexua: " + pertsona.getPisua());
        System.out.println("Sexua: " + pertsona.getAltuera());
        sc.close();
    }
}
