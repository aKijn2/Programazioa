/* Adibide honek salbuespenak nola harrapatzen diren erakusten du, hoien artean erabiltzaileak sortutako salbuespenak */

import java.util.*;

public class IkusiPertsona
{
	public static void main(String argumentos[])
	{
		int			adina;
		boolean		error;
		Scanner		teklatua	= new Scanner(System.in);
		Pertsona	p			= new Pertsona();
		do
		{
			error = false;
			System.out.println("Adina sartu: ");
			try
			{
				adina = teklatua.nextInt();
				p.setAdina(adina);
				System.out.println(p.toString());
				System.out.println("Adinaren erro karratua: " + p.erroKarratua());

			} 
			catch (InputMismatchException e)
			{
				System.out.println("\nZenbakiak bakarrik sartu daitezke.");
				teklatua.next();
				error = true;
			} 
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				error = true;
			}
			
		} while (error);
		
		System.out.println("Programa amaitu da");
	}
}

