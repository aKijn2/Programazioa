package p05_11Ariketa;

public class Haurtxoa {

	/*
	 * Kode honek erakutxiko diguna izango da lehenik Ondo hazi gabeko haurra naiz
	 * Ondoren beste linea batean jarriko idgu Kaixo, (8) hilabete ditut.
	 * eta azkenik negarra egingo du.
	 */

	Haurtxoa(int i) {

		this("Ondo hazi gabeko haurra naiz");

		System.out.println("Kaixo, " + i + " izena dut");

	}

	/*
	 * Xabier izena dut jartzeko egingo duguna izango da 8 ordez new haurtxoan
	 * xabier jarriko dugu
	 * eta izena dut jarriko dugu string atalean..
	 */

	Haurtxoa(String s) {

		System.out.println("Kaixo, " + s + " izena dut.");

	}

	void NegarEgin() {

		System.out.println("Buaaaaaaaaaa");

	}

	public static void main(String[] args) {

		new Haurtxoa("Xabier").NegarEgin();

	}

}