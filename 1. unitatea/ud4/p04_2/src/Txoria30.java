public class Txoria30 {

    /**
     * Atributuak edo propietateak
     */
    private static int zenbatTxori = 0;
    private char kolorea;
    private int adina;

    /**
     * Metodoak edo comportamenduak
     */
    static void txoriBerria() {
        zenbatTxori++;
    };

    Txoria30() {
        kolorea = 'b';
        adina = 0;
        txoriBerria();
    }

    Txoria30(char k, int a) {
        kolorea = k;
        adina = a;
        txoriBerria();
    }

    /**
     * Metodo estatikoak
     */
    static void erakutsiTxoriak() {
        System.out.println(zenbatTxori);
    };

    /**
     * Metodoa
     * 
     * @param args main metodoan jasotako parametroak
     */
    public static void main(String[] args) {
        Txoria30 p1, p2;
        p1 = new Txoria30();
        p2 = new Txoria30('u', 3);
        p1.erakutsiTxoriak();
        p2.erakutsiTxoriak();
    }
}