package IkusiTaula;

import java.io.*;
import java.util.*;

public class IkusiTaula
{
	public static void main(String args[]) throws IOException {
		String         izena;
		int            adina;
		double         pisua;
		
		Scanner        kontsolaTeklatua = new Scanner(System.in);
		
		TaulaDB t      = new TaulaDB("datuak.dat");

		
		System.out.println("izena: ");
		izena = kontsolaTeklatua.nextLine();
		
		System.out.println("adina: ");
		adina = kontsolaTeklatua.nextInt();
		
		System.out.println("pisua: ");
		pisua = kontsolaTeklatua.nextDouble();
		
		int nR = t.getErregistroaKop();
		nR++;
		
		t.idatziErregistroa(izena, adina, pisua, nR);
		
		for (int i = 1; i <= nR; i++)
		{
			Erregistroa r = t.irakurriErregistroa(i);
			System.out.println(r.erakutsiErregistroa());
		}
		
		t.itxiTaula();
		
		System.out.println("Programa amaitu da");
	}
}