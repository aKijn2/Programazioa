public class Kotxea {
    private String marka;
    private String modeloa;
    private String kolorea;
    private int urtea;

    public Kotxea(String marka, String modeloa, String kolorea, int urtea) {
        this.marka = marka;
        this.modeloa = modeloa;
        this.kolorea = kolorea;
        this.urtea = urtea;
    }

    /**
     * Geterrak
     * @return marka, modeloa, kolorea eta urtea
     */
    public String getMarka() {
        return marka;
    }

    public String getModeloa() {
        return modeloa;
    }

    public String getKolorea() {
        return kolorea;
    }

    public int getUrtea() {
        return urtea;
    }

    @Override
    public String toString() {
        return "Kotxea{" +
                "marka='" + marka + '\'' +
                ", modeloa='" + modeloa + '\'' +
                ", kolorea='" + kolorea + '\'' +
                ", urtea=" + urtea +
                '}';
    }
}
