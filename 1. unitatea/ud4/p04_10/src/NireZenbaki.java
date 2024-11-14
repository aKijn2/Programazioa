public class NireZenbaki {
    private int zenbakia;

    // Eraikitzailea
    public NireZenbaki(int zenbakia) {
        this.zenbakia = zenbakia;
    }

    /**
     * Zenbakiaren bikoitza lortzeko metodoa
     * @return Zenbakiaren bikoitza
     */
    public int bikoitza() {
        return 2 * zenbakia;
    }

    /**
     * Zenbakiaren hirukoitza lortzeko metodoa
     * @return Zenbakiaren hirukoitza
     */
    public int hirukoitza() {
        return 3 * zenbakia;
    }

    /**
     * Zenbakiaren laukoitza lortzeko metodoa
     * @return Zenbakiaren laukoitza
     */
    public int laukoitza() {
        return 4 * zenbakia;
    }
}
