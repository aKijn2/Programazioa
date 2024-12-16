import java.io.*;
import java.util.*;

public class FitxIrakurri {
	public static void main(String args[]) {

		String fitxIzena;
		try (Scanner t = new Scanner(System.in)) {

			String c;

			try {
				System.out.println("Fitx izena:");
				fitxIzena = t.nextLine();

				File kanala1 = new File(fitxIzena);

				FileInputStream fluxua = null;

				/**
				 * Esaten gaude kanala1 irakurgarri baldin bada sortuko dugu datuak irakurtzkeo
				 * fluxua.
				 */
				if (kanala1.canRead()) {

					fluxua = new FileInputStream(kanala1);
					byte[] a = new byte[1];

					/**
					 * Irakirru dezaken bitarte dena irakurtzeaz bukatzerakoan gelditu egingo da eta
					 * imprimatuko du irakurritakoa.
					 */
					while (fluxua.read(a) != -1) {
						c = new String(a);
						System.out.print(c);
					}
					fluxua.close();

				}
			} catch (Exception e) {
				// Ez baldin badago ezer errorea saltatuko digu.
				System.out.println("Fitxategia irakurtzean akatsa");
			}
		}
	}
}
