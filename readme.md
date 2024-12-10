## zer flata da:

- Falta da 10 ariketa egitea.

Herentziaren oinarriak

Herentzia kodea berrerabiltzeko oinarria da.
Javan klase batek ezin du hainbat motatatik heredatu.
Klase guztiek dute superklase bat edo ama/aita klase bat.
Klase bat idaztean, klase jakin batetik heredatzen ez badu, Object klasetik heredatzen du (java.lang. Object)

Klase-egitura bat egingo dugu:

Object ----> Figura ----> Laukia

Sartu herentzia izeneko proiektu berri batean, aurreko hiru klaseak, eta ikusi zer gertatzen den: Laukia klasea Figura klaseko azpiklase bat da. Laukia klaseak Figura klaseko metodoak erabil ditzake, nahiz eta Laukia klasean definituta ez egon (Figura klasean private gisa ez badaude). Jakina, azpiklasearen metodoak (Laukia) ezin dira gainklasean erabili (Figura klasean).

```java
public class Figura
{
	private String kolorea;

	public void setKolorea(String s) {
		kolorea = s;
	}

	public String getKolorea() {
		return kolorea;
	}

}

public class Laukia extends Figura
{
	private int aldea;

	Laukia(int l)
	{
		this.aldea = l;
	}

	public int getAzalera() {
		return aldea * aldea;
	}
}

public class TestFigura
{
	public static void main(String[] args)
	{
		Laukia c = new Laukia(5);
		c.setKolorea("Berdea"); // Figura klaseko metodoari deia

		System.out.println(c.getKolorea()); // Figura klaseko metodoari deia
		System.out.println(c.getAzalera()); // Laukia klaseko metodoari deia
	}

}
```
