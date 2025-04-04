import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * Bi Figura objektu sortzen ditu, haien perimetroak kalkulatzen ditu eta
         * konparatzen ditu.
         * 
         * Ondoren, zein figurak duen perimetro handiagoa edo perimetro bera duten
         * inprimatzen du.
         * 
         * Salbuespen bat gertatzen bada, salbuespena harrapatu eta errore mezua
         * inprimatzen du.
         */
        try {
            Figura figura1 = SortuFigura();
            Figura figura2 = SortuFigura();

            double perimetroa1 = figura1.itzuliPerimetroa();
            double perimetroa2 = figura2.itzuliPerimetroa();

            if (perimetroa1 > perimetroa2) {
                System.out.println("Figura 1 perimetro handiena du: " + perimetroa1);
            } else if (perimetroa2 > perimetroa1) {
                System.out.println("Figura 2 perimetro handiena du: " + perimetroa2);
            } else {
                System.out.println("Bi irudiek perimetro bera dute: " + perimetroa1);
            }
        } catch (Exception e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }

    /**
     * Erabiltzailearen sarreran oinarritutako Figura objektu berri bat sortzen du.
     * 
     * @return zehaztutako alde kopurua eta alde luzera duen Figura objektu berri
     *         bat itzultzen du.
     * @throws Exception Figura objektua sortzean errore bat gertatzen bada.
     */

    public static Figura SortuFigura() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sartu alde kopurua: ");
        int aldeKopurua = scanner.nextInt();

        System.out.print("Sartu alde bakoitzaren luzera: ");
        double aldeLuzera = scanner.nextDouble();

        try {
            return new Figura(aldeKopurua, aldeLuzera);
        } catch (IllegalArgumentException e) {
            System.out.println("Errorea: " + e.getMessage());
            throw e;
        }
    }
}