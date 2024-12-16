import java.io.*;

public class TestuFitxKopiatu {

	public static void main(String args[]) {

		try {
			/**
			 * Sartutako fitxategiak irakurri eta idatzi
			 */
			File inFile = new File(args[0]);
			File outFile = new File(args[1]);
			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;

			/**
			 * Fitxategi batetik karaktere bakoitzeko irakurri eta bestera idatzi
			 */
			while ((c = in.read()) != -1) {
				out.write(c);
				System.out.print((char) c);
			}

			/**
			 * Fitxategiak itxi
			 */
			in.close();
			out.close();

			/**
			 * Arazo kontrolatzaileak (Exception) kontrolatzen dira eta errore mezua
			 * itzultzen du.
			 */
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		System.out.println("Kopia ondo egin da");
	}
}