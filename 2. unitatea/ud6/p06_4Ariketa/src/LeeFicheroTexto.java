
import java.io.*;

public class LeeFicheroTexto {
	public static void main(String args[]) {
		String testua = "";
		try {
			FileReader flE = new FileReader("agenda.txt"); // fluxua
			BufferedReader fE = new BufferedReader(flE); // iragazkia

			while (testua != null) {
				testua = fE.readLine(); // irakurri testu-lerro bat
				if (testua != null) {
					int posi = testua.indexOf(","); // komaren kokapena
					String iz = testua.substring(0, posi); // atera izena
					String telefonoa = testua.substring(posi + 1); // atera telefonoa
					System.out.print("Izena:" + izena);
					System.out.println("Telefonoa:" + telefonoa);
				}
			}
			fE.close();
		} catch (IOException e) {
			System.out.println("fitxategian errorea");
		}
	}
}