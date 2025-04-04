public class Balidatu
{
	public static void zuzenaDa(boolean zuzena) throws NireSalbuespena
	{
		if(!zuzena)
			throw new NireSalbuespena();
	}
	
	public static void zuzenaDa(boolean zuzena, String mezua) throws NireSalbuespena
	{ 
		if(!zuzena)
			throw new NireSalbuespena(mezua);
	}
}
