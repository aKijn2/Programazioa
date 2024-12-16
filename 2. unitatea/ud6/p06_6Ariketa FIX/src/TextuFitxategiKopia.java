import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextuFitxategiKopia {

    public static void main(String[] args) {

        // Kopiatu nahi den fitxategiaren ruta
        String lehenDirekzioa = "./";

        // Kopiatutako fitxategiaren helbidea
        String direkzioBerria = "./";

        try (FileReader reader = new FileReader(lehenDirekzioa + "informazioa.txt");
                FileWriter writer = new FileWriter(direkzioBerria + "informazioaKopia.txt")) {

            int idatzi;
            while ((idatzi = reader.read()) != -1) {
                // Irakurritako testua idatzi fitxategi berrian
                writer.write(idatzi);
            }
            // Mezua pantailan inprimatu ondoren
            System.out.println("Fitxategia ongi kopiatu da.");

        } catch (IOException e) {
            // Errore bat gertatzen denean
            System.out.println("Errore bat gertatu da.");
            e.printStackTrace();
        }
    }
}
