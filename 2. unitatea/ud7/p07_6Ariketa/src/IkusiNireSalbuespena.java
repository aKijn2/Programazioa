import java.util.*;

/**
 * Salbuespen pertsonalizatu bat erabilita datu bat nola balidatu erakusten digu
 */
class IkusiNireSalbuespena {
	public static void main(String args[]) {
		Scanner teklatua = new Scanner(System.in);
		int i = 0;
		boolean error;

		do {
			error = false;

			try {
				System.out.println("Sartu zenbaki oso positibo bat: ");
				i = Integer.parseInt(teklatua.nextLine());

				Balidatu.zuzenaDa(i > 0);
			} catch (NireSalbuespena e) {
				System.out.println(e.getMessage());
				error = true;
			} catch (Exception e) {
				System.out.println("Akatsa. Datu okerra: " + e.getMessage());
				error = true;
			}
		} while (error);

		System.out.println("Onartu da sartitako balioa: " + i + "\nPrograma amaitu da");
	}
}
