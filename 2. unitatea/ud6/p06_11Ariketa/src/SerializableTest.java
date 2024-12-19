import java.io.*;
import java.util.*;

public class SerializableTest {
	public static void main(String args[]) {
		String testua;
		int altuera;

		try (Scanner teklatua = new Scanner(System.in)) {
			System.out.println("Izen arrunta: ");
			testua = teklatua.nextLine();

			Zuhaitza p = new Zuhaitza(testua);

			System.out.println("Izen zientifikoa: ");
			testua = teklatua.nextLine();
			p.setIzenZientifikoa(testua);

			System.out.println("Altuera batazbestekoa: ");
			altuera = teklatua.nextInt();
			p.setBatazbestekoAltuera(altuera);

			/**
			 * tmp fitxategia sortuko dugu bertan gordetzeko (tmp = tenporala) Zuhaitza
			 */
			try (FileOutputStream f = new FileOutputStream("tmp");
					ObjectOutputStream fis = new ObjectOutputStream(f)) {
				fis.writeObject(p);
			}

			/**
			 * tmp fitxategia ireki
			 */
			try (FileInputStream fe = new FileInputStream("tmp");
					ObjectInputStream fie = new ObjectInputStream(fe)) {
				Zuhaitza z = (Zuhaitza) fie.readObject();
				System.out.println(z.erakutsiZuhaitza()); // pantaila erakutsi irakurritakoa
			}

			/**
			 * Hiru exception-ak tratatzen ditugu
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}