public class NireSalbuespena extends RuntimeException

{
	public NireSalbuespena()
	{
		super("Zenbakia positiboa izan behar du.");
	}
	
	public NireSalbuespena(String mezua)
	{
		super(mezua);
	}
}
