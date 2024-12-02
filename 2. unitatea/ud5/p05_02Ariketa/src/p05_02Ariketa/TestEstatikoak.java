package p05_02Ariketa;

public class TestEstatikoak {
	public static void main(String[] args) {

		/* Hiru emaitza emango digu bi aldiz inprimatuta */
		/* Emen egiten duguna izango da hiru kohete sortu. */
		Kohetea k1 = new Kohetea();
		Kohetea k2 = new Kohetea();
		Kohetea k3 = new Kohetea();

		/*
		 * Hemen egiten hari garena da eskatu koeteari inprimatzeko koetea 1 eta 3
		 * egingo duena izango da 2 kohtea inprimate 3 balorearekin zergatik hiru kohete
		 * ditugu.
		 */
		System.out.println(k1.getKohetea());
		System.out.println(k3.getKohetea());
	}
}