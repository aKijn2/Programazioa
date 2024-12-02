package p05_05Ariketa;

/**
 * The Class KudeatuLaukizuzena.
 * 
 * Programa honek Laukizuzena klasea erabiliz lauki baten kudeaketa adibidea
 * erakusten du.
 */
public class KudeatuLaukizuzena {

	public static void main(String[] args) {

		// Laukizuzena objektuak sortu eta hasieratu
		Laukizuzena r1 = new Laukizuzena(5, 7);
		Laukizuzena r2 = new Laukizuzena();
		Laukizuzena r3 = new Laukizuzena(r1);

		// r2 laukia handitu eta emaitzak inprimatu
		r2.handituZabalera();
		r2.handituAltua();
		System.out.println("Altua:" + r1.getAltuera());
		System.out.println("Zabalera:" + r1.getZabalera());

		// Beste Laukizuzena objektuak sortu
		Laukizuzena r4 = new Laukizuzena(5, 7);
		Laukizuzena r5 = new Laukizuzena(5, 7);
		Laukizuzena r6 = r4;

		System.out.println();
		// Objektuak berdinak dira konparatzen (erreferentziak berdinak ez direnean ere)
		if (r4.equals(r5))
			System.out.println("r4 eta r5 berdinak dira");

		// Objektuak berdinak dira konparatzen (erreferentziak berdinak direnean)
		if (r4.equals(r6))
			System.out.println("r4 eta r6 berdinak dira");

		System.out.println();
		// Objektuen informazioa inprimatu (toString() metodoa erabiliz)
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(r3.toString());
		System.out.println(r4.toString());
		System.out.println(r5.toString());
		System.out.println(r6.toString());
	}
}
