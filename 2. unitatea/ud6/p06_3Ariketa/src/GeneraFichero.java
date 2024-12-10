
/* Agenda.txt izeneko lerroz lerroko testu-fitxategia sortzea.
* Lehenengo izena sartzen da eta gero telefonoa
* Izen gisa enter sakatzen denean amaitzen da
Reader eta Writer-etik eratorritako klaseak erabiltzen dira.
16 biteko streamsa (UNICODE karaktereak) */

import java.io.*;
import java.util.*;

public class GeneraFichero {
	public static void main(String args[]) {
		Scanner teklatua = new Scanner(System.in);
		String izena;

		try {
			// fitxategia sortu
			FileWriter flS = new FileWriter("agenda.txt"); // fluxua
			BufferedWriter fS = new BufferedWriter(flS); // iragazkia

			/**
			 * Izena eta telefonoa sartu eta fitxategian idatzi
			 */
			do {
				System.out.println("sartu izena");
				izena = teklatua.nextLine();

				/**
				 * Izenaren tamaina 0 baino handiagoa bada, telefonoa sartu eta fitxategian
				 * idatzi
				 */
				if (izena.length() > 0) {
					System.out.println("telefonoa");
					String telefonoa = teklatua.nextLine();
					fS.write(izena + "," + telefonoa);// idatzi testu-lerroak fitxategian
					fS.newLine();// linea-jauzia
				}

				// Izenaren tamaina 0 bada ez badugu ezer idazten programa amaituko da.
			} while (izena.length() > 0);

			fS.close();
			System.out.println("Fitxategia sortu da");

		} catch (IOException e) {
			System.out.println("fitxategiko errorea");
		}
	}
}
