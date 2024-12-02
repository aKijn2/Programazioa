// Figura interfazea inplementatuko dugu
public class Laukizuzena implements Figura {

	private int oinarria;
	private int altuera;

	public Laukizuzena(int b, int a) {

		oinarria = b;
		altuera = a;
	}

	// Interfazea definitu gabe geratu diren metodo guztiak definitu behar dura
	// klasean
	public int azalera() {
		return oinarria * altuera;
	}

}
