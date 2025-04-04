import java.util.Scanner;

public class zereginak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int zenbaki = 0;
        boolean zenbakiEgokia = false;

        // Zenbakia eskatu eta baldintzak bete arte errepikatu
        while (!zenbakiEgokia) {
            try {
                System.out.println("10etik gorako eta 30etik beherako zenbaki osoa sartu mesedez: ");
                zenbaki = sc.nextInt();
                if (zenbaki > 10 && zenbaki < 30) {
                    zenbakiEgokia = true;
                } else {
                    System.out.println("Zenbakia ez da egokia. Saiatu berriro.");
                }
            } catch (Exception e) {
                System.out.println("Errorea zenbakia sartzean: " + e.getMessage());
                sc.next();
            }
        }

        // Zenbakia 5ekin zatigarria den ikertu eta erakutsi
        if (zenbaki % 5 == 0) {
            System.out.println("Zenbakia 5ekin zatigarria da.");
        } else {
            System.out.println("Zenbakia ez da 5ekin zatigarria.");
        }

        // Erabiltzailearen izena eskatu
        System.out.println("Sartu izena:");
        String erabilIzena = sc.next();

        try {
            System.out.println("Izenaren karaktere kopurua: " + erabilIzena.length());

            for (int i = 0; i < erabilIzena.length(); i++) {
                System.out.println("Izenaren " + (i + 1) + " karakterea: " + erabilIzena.charAt(i));
            }

            System.out.println("Izena letra larriz: " + erabilIzena.toUpperCase());
            System.out.println("Izena letra txikiz: " + erabilIzena.toLowerCase());

            if (erabilIzena.contains("ñ") || erabilIzena.contains("Ñ")) {
                System.out.println("Izenak ñ letra dauka.");
            } else {
                System.out.println("Izenak ez dauka ñ letrarik.");
            }

        } catch (Exception e) {
            System.out.println("Errorea izenaren txostena egitean: " + e.getMessage());
        }
        sc.close();
    }
}