import java.util.Scanner;
import ekintzakBi.matematikak.Eragiketak;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari zenbaki bat eskatu
        System.out.print("Sartu zenbaki bat: ");
        int zenbaki = scanner.nextInt();

        // Batura kalkulatu
        int baturaEmaitza = Eragiketak.batura(zenbaki, 10);
        System.out.println("Zenbakiaren eta 10aren batura: " + baturaEmaitza);

        // Potentzia kalkulatu
        int potentziaEmaitza = Eragiketak.potentzia(zenbaki, 2);
        System.out.println("Zenbakiaren 2. potentzia: " + potentziaEmaitza);

        scanner.close();
    }
}
