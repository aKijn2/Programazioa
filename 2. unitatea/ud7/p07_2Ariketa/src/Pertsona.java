public class Pertsona {
    private int adina;

    public void setAdina(int adinaBerria) throws Exception {
        if (adinaBerria < 0 || adinaBerria > 100)
            throw (new Exception("Adin balioagabea."));
        adina = adinaBerria;
    }

    public String toString() {
        return "adina: " + adina;
    }

}