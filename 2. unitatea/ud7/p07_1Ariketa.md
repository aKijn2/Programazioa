```java
try {
/* Akatsen bat eragin dezaketen jarraibideak, egoera jakin batzuk gertatzen badira */
}
catch (Errore mota e)
{
/* Hemendik pasatuko litzateke programa, baldin eta "TipoError" motako tryan dagoen jarraibideren batean errore bat gertatzen bada */
}
```

- Errorea gertatzen bada, utzi egingo dio try-an dauden aginduak exekutatzeari, catch-ean dauden aginduak exekutatzeko.

- Errorerik EZ badago, ez da beteko catch-ean dauden agindu bat ere, eta try-an dauden agindu guztiak exekutatuko ditu.

- Aztertu 1. adibidean agertzen den kodea eta hausnartu honako galdera hauei buruz:

1. Zer gertatzen da erabiltzaileak 0 bat bigarren zenbaki gisa sartzen badu?

   Erabiltzaileak 0 bat sartzen badu bigarren zenbaki bezala, zeroz zatitzeko errorea gertatuko da. Horrek ArithmeticException eragingo dezake.

2. Zer gertatzen da erabiltzaileak lehen zenbaki gisa letra bat sartzen badu?

   Erabiltzaileak lehen zenbaki gisa letra bat sartzen badu, NumberFormatException salbuespena gertatuko da. Horrek adierazten du sartutako balioa ezin dela zenbaki bihurtu, eta catch bloke egokian tratatu beharko da.

Ez dago zertan egon catch bat bakarrik; bat baino gehiago ere egon daitezke, eta horietako bakoitzak errore mota bat atzematen du.

try-ren jarraibideren batean errore bat gertatzen denean, aurkitu ahala aztertuko ditu catch-ak, eta atzematen duen errore mota eta gertatu den errorea bat datozela adieraziko du. Catch batean sartzen zarenean, ez da hurrengoetatik pasatuko. Horregatik, catch-en ordena oso garrantzitsua da. Salbuespenen hierarkia kontuan hartu behar da.
Dakigunez, Exception klaseak kontrolatzen diren errore mota guztiak barne hartzen ditu, beraz, ezin dugu lehenik eta behin jarri, orduan beti sartuko bailitzateke bertan eta ez bailitzateke azpitik leudekeenetatik igaroko.

- Aztertu 2. adibidean agertzen den kodea eta hausnartu honako honi buruz:

1. Zer alde legoke programan do-while egituran errore aldagaia kenduz gero?

   Aldagaia ez da definitzen ezin da erabili programa osoan zehar.

2. Zer gertatzen da erabiltzaileak 0 bat bigarren zenbaki gisa sartzen badu?

   Erabiltzaileak 0 bat sartzen badu, zeroz zatitzeko errorea gertatuko da. Horrek ArithmeticException eragingo du.

3. Zer gertatzen da erabiltzaileak lehen zenbaki gisa letra bat sartzen badu?

   Saltatuko du exceptiona non adierazten du sartutako balioa ezin dela zenbaki bihurtu.

4. Zer gertatzen da azken catch-a lehenengo gisa jarri eta 2. eta 3. urratsekin exekuzioa errepikatzen baduzu?

   Ez du exekutatuko zergatik yada lehenengo catch-a arazoak kudeatuko ditu.

Try eta catch blokeez gain, finally blokea dago. Multzo horretan sartzen dira beti exekutatzea nahi ditugun jarraibideak, akatsen bat gertatu den edo ez alde batera utzita. Finally-ak beti egon behar du catch bloke guztien amaieran. Adibidez:

Fitxategi bat irekitzen badugu irakurtzeko, garrantzitsua da ziurtatzea gero itxi egingo dugula. Kontsulta bat egiteko datu-base batera konektatzen bagara, garrantzitsua izaten da gero konexioa ixtea. Hori irakurketa-eragiketek arrakasta izan edo ez.

```java
try {
ireki fitxategia ();
leeFitxategia ();
}

catch (e salbuespena) {
trataeraErrorea (e);
}

finally {
itxiFitxategia ();
}
```

Fitxategia irekitzean edo irakurtzean salbuespenen bat gertatzen bada, salbuespena tratatuko da eta, ondoren, finallya exekutatuko da, fitxategia itxiz. Salbuespenik ez badago, try-aren ondoren, finallya ere exekutatuko da eta fitxategia itxi egingo da.

Finally blokea aukerakoa da.

Adibidea 1:

```java
public class Salbuespenak1
{

	public static int salbuespenak(int z1, int z2)
	{
		int emaitza;

		try
		{
			emaitza = z1 / z2;
		}
		catch (ArithmeticException e)
		{
			emaitza = 0;
		}

		return emaitza;
	}

	public static void main(String args[])
	{
		String	a1, a2;
		int		z1, z2, emai;

		if (args.length != 2)
		{
			System.out.println("Bi zenbaki behar ditugu.");
		}
		else
		{
			a1	= args[0];
			a2	= args[1];
			try
			{
				z1		= Integer.parseInt(a1);
				z2		= Integer.parseInt(a2);
				emai	= salbuespenak(z1, z2);

				if (z2 == 0 && z1 != 0)
				{
					System.out.println("Emaitza infinito da.");
				}
				else if (z2 == 0 && z1 == 0)
				{
					System.out.println("indeterminazioa.");
				}
				else
				{
					System.out.printf("Emaitza %d / %d, %d da.", z1, z2, emai);
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Ezin dituzu letrak sartu!");
			}
		}
	}
}
```

Adibidea 2:

```java

/* Salbuespen bat mota arabera nola harrapa eta trata daitekeen erakusten du.
* Sortutako salbuespena ez bada lehenengo catch-aren klasekoa, honako hau ikertzen da: eta catch blokeak harrapatu arte.
Blokeak edozein mota harrapatzen du salbuespen klase guztiak Exception klase datozelako
*/

import java.util.Scanner;

public class Salbuespenak2
{
	public static void main(String args[])
	{
		int		zbk1, zbk2, emai;
		String	textu;
		Scanner	teklatu	= new Scanner(System.in);
		boolean	error	= false;

		do
		{
			try
			{
				error = false;
				System.out.println("Sartu lehenengo zenbakia:");
				textu	= teklatu.nextLine();
				zbk1	= Integer.parseInt(textu);
				System.out.println("Sartu bigarren zenbakia:");
				textu	= teklatu.nextLine();
				zbk2	= Integer.parseInt(textu);
				emai	= zbk1 / zbk2;
				System.out.printf("%d eta %d arteko zatiketaren emaitza  %d da", zbk1, zbk2, emai);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Akatsa zenbakira bihurtzeko garaian");
				error = true;
			}
			catch (ArithmeticException e)
			{
				System.out.println("Zati 0 egin nahi izan da");
				error = true;
			}
			catch (Exception e)
			{
				System.out.println("Salbuespen ezezaguna");
				error = true;
			}

		} while (error);
	}
}
```
