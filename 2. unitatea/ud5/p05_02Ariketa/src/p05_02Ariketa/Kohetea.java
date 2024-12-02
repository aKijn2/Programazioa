package p05_02Ariketa;

public class Kohetea {
	/* Static kentzen bladin badugu atributu bakrra irakurriko digu */
	private static int koheteKop = 0;// atributU estatikoa edo klasekoa
	// kasu honetan ez dago instantzia-atributurik

	// eskaera-metodoak (kasu honetan ez dago metodo estatikorik edo
	// klase-metodorik)
	// eraikitzailea
	Kohetea() {
		/*
		 * Static kentzen badugu bakarra erakutsiko digu
		 * baino gehitzen baldin badugu koheteaKop++ 2 erakutsiko du.
		 */
		koheteKop++;
	}

	public int getKohetea() {
		return koheteKop;
	}

}