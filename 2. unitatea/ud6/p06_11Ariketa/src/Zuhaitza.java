import java.io.*;

/**
 * Serializatu nahi dugunez
 */
public class Zuhaitza implements Serializable {
	private String izenArrunta;
	private String izenZientifikoa;
	private int batazbestekoAltuera;

	public Zuhaitza(String izena) {
		izenArrunta = izena;
	}

	public void setIzenZientifikoa(String nombre) {
		izenZientifikoa = nombre;
	}

	public void setBatazbestekoAltuera(int altura) {
		batazbestekoAltuera = altura;
	}

	public String erakutsiZuhaitza() {
		return izenArrunta + " " + izenZientifikoa + " " + batazbestekoAltuera;
	}
}
