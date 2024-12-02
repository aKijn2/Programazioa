public class Data
{
	private int eguna;
	private int hilabetea;
	private int urtea;

	public Data()
	{
	}

	public Data(int e, int h, int u)
	{
		eguna     = e;
		hilabetea = h;
		urtea     = u;
	}

	public int getEguna() {
		return eguna;
	}

	public void setEguna(int eguna) {
		this.eguna = eguna;
	}

	public int getHilabetea() {
		return hilabetea;
	}

	public void setHilabetea(int hilabetea) {
		this.hilabetea = hilabetea;
	}

	public int getUrtea() {
		return urtea;
	}

	public void setUrtea(int urtea) {
		this.urtea = urtea;
	}

	// Object-etik jasotako metodoa gainidatziko dugu data nahi den formatuan erakusteko
	public String toString() {
		return urtea + "/" + hilabetea + "/" + eguna;
	}

	// Object-etik jasotako metodoa gainidatziko dugu, atributuen balioak bat datozenean true itzul dezan eta, kasu kontsolidarioan, huts egin dezan
	public boolean equals(Object o) {
		Data bestea = (Data) o;
		return eguna == bestea.eguna && hilabetea == bestea.hilabetea && urtea == bestea.urtea;
	}
}
