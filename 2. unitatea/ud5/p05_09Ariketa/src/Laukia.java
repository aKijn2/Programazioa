// Laukia kalseak Fgura interfazea inplementatzen du
public class Laukia implements Figura
{

	private int aldea;

	public Laukia(int aldeLuzera)
	{

		aldea = aldeLuzera;
	}

	// Interfazea definitu gabe geratu diren metodo guztiak definitu behar dura klasean
	public int azalera() {
		return aldea * aldea;
	}

}