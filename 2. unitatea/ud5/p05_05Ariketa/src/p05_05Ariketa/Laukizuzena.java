package p05_05Ariketa;

public class Laukizuzena {
	private int zabalera;
	private int altuera;
	public String getAltuera;
	public String getZabalera;

	Laukizuzena(int an, int al) {
		this.zabalera = an;
		this.altuera = al;
	}

	Laukizuzena() {
		zabalera = altuera = 0;
	}

	Laukizuzena(int dato) {
		zabalera = altuera = dato;
	}

	Laukizuzena(Laukizuzena r) {
		this.zabalera = r.getZabalera();
		this.altuera = r.getAltuera();
	}

	public int getZabalera() {
		return this.zabalera;
	}

	public int getAltuera() {
		return this.altuera;
	}

	public Laukizuzena handituZabalera() {
		zabalera++;
		return this;
	}

	public Laukizuzena handituAltua() {
		altuera++;
		return this;
	}

} 
