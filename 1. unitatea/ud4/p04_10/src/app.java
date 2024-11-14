import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * Eskatzen digu zenbaki bat sartzeko
         */
        System.out.println("Sartu zenbaki bat: ");
        int zenbakia = sc.nextInt();

        /**
         * Zenbaki bat sortu eta erabili
         */
        NireZenbaki nireZenbaki = new NireZenbaki(zenbakia);

        /**
         * Zenbakiaren bikoitza, hirukoitza eta laukoitza kalkulatu eta imprimatu
         */
        System.out.println("Zenbakiaren bikoitza: " + nireZenbaki.bikoitza());
        System.out.println("Zenbakiaren hirukoitza: " + nireZenbaki.hirukoitza());
        System.out.println("Zenbakiaren laukoitza: " + nireZenbaki.laukoitza());
    }
}
