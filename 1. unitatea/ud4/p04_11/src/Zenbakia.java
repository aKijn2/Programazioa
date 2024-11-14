public class Zenbakia {
    private int balioa;

    /**
     * Eraikitzailea. Balioa 0-ra ezarriko du
     */
    public Zenbakia() {
        this.balioa = 0;
    }

    /**
     * Eraikitzailea. Balioa zehaztuta ematen duena
     * 
     * @param zenbat Zenbakia zehaztu nahi den balioa
     */
    public void gehitu(int zenbat) {
        this.balioa += zenbat;
    }

    /**
     * Kendu metodoa. Zenbaki bat barne-balioatik kendu ahal izateko metodoa
     * 
     * @param zenbat Kendu nahi den zenbakia
     */
    public void kendu(int zenbat) {
        this.balioa -= zenbat;
    }

    /**
     * GetBalioa metodoa. Barne-balioa itzultzen du
     * 
     * @return Barne-balioa
     */
    public int getBalioa() {
        return this.balioa;
    }

    /**
     * GetBikoitza metodoa. Barne-balioaren bikoitza itzultzen du
     * 
     * @return Barne-balioaren bikoitza
     */
    public int getBikoitza() {
        return this.balioa * 2;
    }

    /**
     * GetHirukoitza metodoa. Barne-balioaren hirukoitza itzultzen du
     * 
     * @return Barne-balioaren hirukoitza
     */
    public int getHirukoitza() {
        return this.balioa * 3;
    }

    /**
     * Zenbakia klaseko balioa aldatzeko metodoa
     * 
     * @param balioa Zenbakiaren balio berria
     */
    public void setZenbakia(int balioa) {
        this.balioa = balioa;
    }
}
