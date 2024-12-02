public class FrogaInterfazea {

	public static void main(String args[]) {

		Figura figura1 = new Laukia(5);
		Figura figura2 = new Laukizuzena(7, 5);

		/*
		 * Horrela ere berdin-berdin funtzionatuko luke: Laukia figura1 = new Laukia(5);
		 * Laukizuzena figura2 = new Laukizuzena(7, 5); Esperientziak esango digu modu
		 * batean edo bestean noiz erabiltzea komeni zaigun
		 */

		System.out.println("Azalera Figura 1: " + figura1.azalera());
		System.out.println("Azalera Figura 2: " + figura2.azalera());
	}
}