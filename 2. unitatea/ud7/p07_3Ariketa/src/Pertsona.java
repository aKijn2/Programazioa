public class Pertsona {
    private int adina;

    public void setAdina(int adinaBerria) throws Exception {
        if (adinaBerria < 0 || adinaBerria > 100)
            throw (new Exception("Adin balioagabea."));
        adina = adinaBerria;
    }

    public int erroKarratua() throws Exception {
        if (adina < 0)
            throw (new Exception("Zenbakia negatiboa da."));
        return (int) Math.sqrt(adina);
    }

    public String toString() {
        return "adina: " + adina;
    }

}