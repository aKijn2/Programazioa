package ekintzakBi.matematikak;

public class Eragiketak {

    // Bi zenbakien batura egiten duen metodoa
    public static int batura(int zenbaki1, int zenbaki2) {
        return zenbaki1 + zenbaki2;
    }

    // Lehen zenbakia bigarrenarekin berretzen duen metodoa
    public static int potentzia(int oinarria, int berretzailea) {
        int emaitza = 1;
        for (int i = 0; i < berretzailea; i++) {
            emaitza *= oinarria;
        }
        return emaitza;
    }
}
