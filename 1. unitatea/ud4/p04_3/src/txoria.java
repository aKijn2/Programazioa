public class txoria {

    /**
     * Atributuak
     */
    private char kolorea;
    private int adina;

    /**
     * Txoriaren adina ezartzen du.
     * 
     * @param e Adina, zenbaki oso moduan.
     */
    public void setAdina(int e) {
        adina = e;
    }

    /**
     * Txoriaren adina inprimatzen du.
     */
    public void printAdina() {
        System.out.println(adina);
    }

    /**
     * Txoriaren kolorea ezartzen du.
     * 
     * @param c Kolorea, karaktere moduan.
     */
    public void setKolorea(char c) {
        kolorea = c;
    }

    // Main metodoa
    public static void main(String[] args) {
        txoria t = new txoria();
        t.setAdina(5);
        t.printAdina();
    }
}
