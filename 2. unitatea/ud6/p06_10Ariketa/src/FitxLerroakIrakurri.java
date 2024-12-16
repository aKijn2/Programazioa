import java.io.*;
import java.util.*;

public class FitxLerroakIrakurri {
	public static void main(String args[]) {
		String fitxIzena = null;
		String textuLerroa;
		int nL = 0;
		int nE = 0;
		Scanner teclado = new Scanner(System.in);

		try {
			System.out.println("Fitxategi izena");
			fitxIzena = teclado.nextLine();

			File c1 = new File(fitxIzena);
			File c2 = new File("./test.txt");
			FileOutputStream f = new FileOutputStream(c2);
			DataOutputStream fls = new DataOutputStream(f);

			if (c1.canRead()) {
				FileReader fle = new FileReader(c1);
				BufferedReader fl = new BufferedReader(fle);

				while (fl.ready() == true) {
					textuLerroa = fl.readLine();
					if (textuLerroa.charAt(0) == '+') {
						fls.writeBytes(textuLerroa + '\r' + '\n');
						System.out.println(textuLerroa);
						nE++;
					}
					nL++;
				}
				fl.close();
			}
			fls.close();
		} catch (Exception e) {
			System.out.println("Fitxategia irakurtzean akatsa:" + e.getMessage());
		}

		System.out.println(nL + " lerro irakurrita");
		System.out.println(nE + " lerro idatzita");
		System.out.println("Exekuzio amaiera");
	}
}