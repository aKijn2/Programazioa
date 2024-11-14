public class Pertsona {

	/**
	 * Pertsona atributuak
	 */
	private int idPertsona;
	private String Izena;
	private int Adina;
	private String Generoa;

	/**
	 * Pertsona klasearen eraikitzailea
	 * 
	 * @param id
	 * @param Izena
	 * @param Adina
	 */
	public Pertsona(int id, String Izena, int Adina) {
		setIdPertsona(id);
		setIzena(Izena);
		setAdina(Adina);
	}

	public Pertsona() {
	}

	/**
	 * Pertsona klasearen eraikitzailea
	 * 
	 * @param id
	 * @param Izena
	 * @param Adina
	 * @param Generoa
	 */
	public Pertsona(int id, String Izena, int Adina, String Generoa) {
		setIdPertsona(id);
		setIzena(Izena);
		setAdina(Adina);
		setGeneroa(Generoa);
	}

	/**
	 * Pertsona klasearen eraikitzailea
	 * 
	 * @param balioa
	 */
	public void setIdPertsona(int balioa) {
		this.idPertsona = balioa;
	}

	/**
	 * Pertsona klasearen eraikitzailea
	 * 
	 * @param balioa
	 */
	public void setIzena(String balioa) {
		this.Izena = balioa;
	}

	/**
	 * Pertsona klasearen eraikitzailea
	 * G edo E izan behar du
	 * @param balioa
	 */
	public void setGeneroa(String balioa) {
		if (balioa.equals("G") || balioa.equals("E"))
			this.Generoa = balioa;
		else
			System.out.println("Generoa G edo E izan behar du");
	}

	/**
	 * Pertsona klasearen eraikitzailea
	 * Adina 55 baino txikiagoa izan behar du
	 * 
	 * @param balioa
	 */
	public void setAdina(int balioa) {
		if (balioa < 55)
			this.Adina = balioa;
		else
			System.out.println("Adina < 55 izan behar du");
	}

	/**
	 * Pertsona klasearen geterrak
	 * 
	 * @return idPertsona, Izena, Adina, Generoa itzultzen ditu
	 */
	public int getIdPertsona() {
		return this.idPertsona;
	}

	public String getIzena() {
		return this.Izena;
	}

	public int getAdina() {
		return this.Adina;
	}

	public String getGeneroa() {
		return this.Generoa;
	}
}
