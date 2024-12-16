/* ErErregistroa definizioa
 * 52 byte dira erErregistroa bakoitza
 */
package IkusiTaula;

public class Erregistroa
{
	private String izena; // 20 karaketere Unicode (40 byte)
	private int    adina; // 4 byte
	private double pisua; // 8 byte

	public Erregistroa(String erIzena, int erAdina, double erPisua)
	{
		izena = erIzena;
		adina = erAdina;
		pisua = erPisua;
	}

	public String erakutsiErregistroa() {
		return izena + " " + adina + " " + pisua;
	}

	public String getIzena() {
		return izena;
	}
}