package p05_04Ariketa;

/**
 * The Class Parametroak.
 * 
 * Programa honek parametroak pasatzearen ondorioz zenbakiak aldatzen duen 
 * metodo bat erakusten du.
 */
public class Parametroak {

	/* Uste dut emango duen emaitza izango da: 1 zenbakiak 1 eta 2 zenbakiak 1 */

	/* Lehenengo metodoa dauka int x horrek egiten duena da bere zenbakia 1 gehitu
	 * Ondoren edukiko dugu bigarren metodoa, array bat iznago dana horrek berdina egiten du
	 * lehenengo posizioan 1 geitzen ud.
	 */

	/**
	 * Aldatu metoduak parametroa hartzen du eta 1 bat gehitzen du.
	 *
	 * @param x the x
	 */
	public static void aldatu(int x) {
		x++;
	}

	/**
	 * Aldatu2 metoduak array bat hartzen du eta lehenengo posizioan 1 bat gehitzen du.
	 *
	 * @param par the par
	 */
	public static void aldatu2(int[] par) {
		par[0]++;
	}


	/**
	 * * Horain emen egiten gaudena da ezarri zbk1 0 valorea eta array bat hasieratzen du. *
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int zbk1 = 0;
		int[] zbki2 = { 0 };

		aldatu(zbk1);
		System.out.println("1. zenbakia:" + zbk1);
		aldatu2(zbki2);
		System.out.println("2. zenbakia:" + zbki2[0]);
	}
}
