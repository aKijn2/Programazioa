public class Ikaslea {

    /**
     * Ikaslearen izena eta adina gordetzeko atributuak.
     */
    String izena;
    int adina;

    /**
     * Ikaslearen izena eta adina gordetzeko atributuak hasieratzen dituen eraikia.
     * 
     * @param n
     * @param e
     */
    Ikaslea(String n, int e) {
        izena = n;
        adina = e;
    }

    /**
     * Ikaslearen izena itzultzen duen metodoa.
     * 
     * @return izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Ikaslearen adina itzultzen duen metodoa.
     * 
     * @return adina
     */
    public int getAdina() {
        return adina;
    }
}