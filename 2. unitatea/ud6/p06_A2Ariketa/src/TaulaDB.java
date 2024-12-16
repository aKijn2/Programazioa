package IkusiTaula;

import java.io.*;

public class TaulaDB {

	private RandomAccessFile nireTaula;
	private int erErregistroaKop;
	private int luzeraR = 52;
	private int desplazamendua = 4;

	public TaulaDB(String taula) {
		try {
			nireTaula = new RandomAccessFile(taula, "rw");
			if (nireTaula.length() == 0)
				erErregistroaKop = 0;
			else
				erErregistroaKop = nireTaula.readInt();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getErregistroaKop() {
		return erErregistroaKop;
	}

	public Erregistroa irakurriErregistroa(int nErregistroa) throws IOException {
		String izena = "";
		int adina;
		double pisua;

		// Emandako posiziora desplazatu punteroa
		nireTaula.seek((nErregistroa - 1) * luzeraR + desplazamendua);

		for (int i = 0; i < 20; i++) {
			izena += nireTaula.readChar();
		}
		adina = nireTaula.readInt();
		pisua = nireTaula.readDouble();

		return (new Erregistroa(izena, adina, pisua));
	}

	public void idatziErregistroa(String izena, int adina, double pisua, int nErregistroa) throws IOException {
		int longitud = izena.length();
		nireTaula.seek((nErregistroa - 1) * luzeraR + desplazamendua);
		for (int i = 0; i < 20; i++) {
			if (i < longitud)
				nireTaula.writeChar(izena.charAt(i));
			else
				nireTaula.writeChar(' ');
		}
		nireTaula.writeInt(adina);
		nireTaula.writeDouble(pisua);
		erErregistroaKop++;
	}

	public void itxiTaula() throws IOException {
		nireTaula.seek(0);
		nireTaula.writeInt(erErregistroaKop);
		nireTaula.close();
	}
}
