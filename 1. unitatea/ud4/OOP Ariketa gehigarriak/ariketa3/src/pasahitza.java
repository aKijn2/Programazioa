public class pasahitza {
    private int longitudea;
    private String pasahitza;

    /**
     * Honek pasahitza gordetzeko klasea da.
     * @param longitudea
     * @param pasahitza
     */
    public pasahitza(int longitudea, String pasahitza) {
        this.longitudea = longitudea;
        this.pasahitza = pasahitza;
    }

    public int getLongitudea() {
        return this.longitudea;
    }

    public String getPasahitza() {
        return this.pasahitza;
    }

    public void setLongitudea(int longitudea) {
        this.longitudea = longitudea;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
}