public class Figura {
    private int aldeKopurua;
    private double aldeLuzera;

    /**
     * Figura objektu bat eraikitzen du zehaztutako alde kopuruarekin eta
     * aldeluzerarekin.
     *
     * @param aldeKopurua alde kopurua
     * @param aldeLuzera  alde luzera
     * @throws IllegalArgumentException mezua itzuli
     */
    public Figura(int aldeKopurua, double aldeLuzera) throws IllegalArgumentException {
        if (aldeKopurua <= 2 || aldeLuzera <= 0) {
            throw new IllegalArgumentException(
                    "Alde kopurua 2 baino handiagoa izan behar da eta alde luzera 0 baino handiagoa izan behar da.");
        }
        this.aldeKopurua = aldeKopurua;
        this.aldeLuzera = aldeLuzera;
    }

    /**
     * Itzuli eta bueltatzen du formaren perimetroa.
     *
     * @return formaren perimetroa, alde kopuruaren eta alde bakoitzaren luzeraren
     *         biderkaduraren arabera kalukulua.
     */
    public double itzuliPerimetroa() {
        return aldeKopurua * aldeLuzera;
    }
}