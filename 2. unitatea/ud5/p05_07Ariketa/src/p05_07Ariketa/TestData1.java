package p05_07Ariketa;

import java.util.Scanner;

import p05_07Ariketa.Data.eguna;

public class TestData1 implements eguna {
	public static void main(String[] args) {

		Data batData = new Data();
		Data biData = new Data();

		Scanner sc = new Scanner(System.in);

		System.out.println("--------------");

		System.out.println("1. data");

		// 1. egutegiaren datuak sortzen ditut
		while (true) {
			System.out.print("Eguna: ");
			int eguna = sc.nextInt();

			// esatne nago eguna 31 baino handiago baldin bada edo 1 baino txikiagoa errorea
			// ematea.
			if (eguna > 31 || eguna < 1) {
				System.out.println("Ezin du 31 baino handiago izan eta 1 baino txikiagoa.");
				continue;
			}

			// Emen egiten ngaoena da ezarri f-ri eguna izatego nik garri dudan eguna.
			// Honek egingo didana izango da eguna gorde f datan.
			batData.setEguna(eguna);
			break;
		}

		while (true) {
			System.out.print("Hilabetea: ");
			int hilabetea = sc.nextInt();

			// esatne nago hilabetea 12 baino handiago baldin bada edo 1 baino txikiagoa
			// errorea ematea.
			if (hilabetea > 12 || hilabetea < 1) {
				System.out
						.println("Hilabeteak 12 baino gehiago ezin ditu izan eta 1 baino txikiago ezin du izan ezta.");
				continue;
			}

			// Emen egiten ngaoena da ezarri f-ri eguna izatego nik garri dudan eguna.
			// Honek egingo didana izango da eguna gorde f datan.
			batData.setHilabetea(hilabetea);
			break;
		}

		// Eta azkenik emen urtea eskatzen digute baino horaingoz ez gaude bukle batea
		// Zergatik ez daukagu arazorik urtearekin al du izan negativoa eta...
		System.out.print("Urtea: ");
		batData.setUrtea(sc.nextInt());

		System.out.println("Emaitza 1:");
		System.out.println(batData);

		System.out.println("--------------");

		System.out.println("2. data");

		/*
		 * Ez dut bigarren taula hau explikatuko zergatik lehenengoaren berdina da
		 * aldatzen dan gauza bakarra dira objetuak f eta e bakoitzka bere data
		 * gordetzen du.
		 */
		// 2. egutegiaren datuak sartu
		while (true) {
			System.out.print("Eguna: ");
			int eguna = sc.nextInt();
			if (eguna > 31 || eguna < 1) {
				System.out.println("Ezin du 31 baino handiago izan eta 1 baino txikiagoa.");
				continue;
			}
			biData.setEguna(eguna);
			break;
		}

		while (true) {
			System.out.print("Hilabetea: ");
			int hilabetea = sc.nextInt();
			if (hilabetea > 12 || hilabetea < 1) {
				System.out
						.println("Hilabeteak 12 baino gehiago ezin ditu izan eta 1 baino txikiago ezin du izan ezta.");
				continue;
			}
			biData.setHilabetea(hilabetea);
			break;
		}

		System.out.print("Urtea: ");
		biData.setUrtea(sc.nextInt());

		System.out.println("Emaitza 2");
		System.out.println(biData);

		System.out.println("--------------");

		System.out.println("Emaitza: ");
		System.out.println("1. data: " + batData);
		System.out.println("2. data: " + biData);

		System.out.println("--------------");

		/*
		 * Emen esaten ari garena da f berdina baldin bada e datarekin
		 * berdinak direla inprimatzeko bestelo esateko dezbersinka dira.
		 */
		if (batData.equals(biData)) {
			System.out.println("Berdinak dira!");
		} else {
			System.out.println("Desberdinak dira!");
		}
		System.out.println("--------------");
	}

	@Override
	public int getEguna() {
		return 0;
	}

	@Override
	public void setEguna(int eguna) {
	}

	@Override
	public int getHilabetea() {
		return 0;
	}

	@Override
	public void setHilabetea(int hilabetea) {
	}

	@Override
	public int getUrtea() {
		return 0;
	}

	@Override
	public void setUrtea(int urtea) {
	}
}