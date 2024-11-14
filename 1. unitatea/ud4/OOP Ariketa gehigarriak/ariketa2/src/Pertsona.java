import java.util.Random;

public class Pertsona {
    // Atributuak
    private String izena;
    private int adina;
    private String dni;
    private char sexua;
    private float pisua;
    private float altuera;

    // Konstanteak
    private static final char SEXU_DEF = 'G';
    private static final int AZPI_PISUA = -1;
    private static final int PISU_IDEALA = 0;
    private static final int GEHI_PISUA = 1;

    // Eraikitzaile lehenetsia
    public Pertsona() {
        this("", 0, SEXU_DEF, 0.0f, 0.0f);
    }

    // Eraikitzailea izena, adina eta sexua
    public Pertsona(String izena, int adina, char sexua) {
        this(izena, adina, sexua, 0.0f, 0.0f);
    }

    // Eraikitzailea parametro guztiekin
    public Pertsona(String izena, int adina, char sexua, float pisua, float altuera) {
        this.izena = izena;
        this.adina = adina;
        this.sexua = sexua;
        this.pisua = pisua;
        this.altuera = altuera;
        this.dni = generaDNI();
    }

    // IMC kalkulatzeko metodoa
    public int kalkulatuIMC() {
        float imc = pisua / (altuera * altuera);
        if (imc < 20) {
            return AZPI_PISUA;
        } else if (imc <= 25) {
            return PISU_IDEALA;
        } else {
            return GEHI_PISUA;
        }
    }

    // Adin nagusikoa den jakiteko metodoa
    public boolean daAdinNagusia() {
        return adina >= 18;
    }

    // Sexua egiaztatzeko metodoa
    private void egiaztatuSexua(char sexua) {
        if (sexua != 'G' && sexua != 'E') {
            this.sexua = SEXU_DEF;
        } else {
            this.sexua = sexua;
        }
    }

    // Objektuaren informazioa itzultzeko metodoa
    @Override
    public String toString() {
        return "Izena: " + izena + ", Adina: " + adina + ", DNI: " + dni + ", Sexua: " + sexua + ", Pisua: " + pisua
                + ", Altuera: " + altuera;
    }

    // DNI sortzeko metodoa
    private String generaDNI() {
        Random random = new Random();
        int zenbakia = random.nextInt(100000000);
        char letra = kalkulatuLetra(zenbakia);
        return String.format("%08d", zenbakia) + letra;
    }

    // DNI letraren kalkulua
    private char kalkulatuLetra(int zenbakia) {
        String letrak = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letrak.charAt(zenbakia % 23);
    }

    // Set metodoak
    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public void setSexua(char sexua) {
        egiaztatuSexua(sexua);
    }

    public void setPisua(float pisua) {
        this.pisua = pisua;
    }

    public void setAltuera(float altuera) {
        this.altuera = altuera;
    }

    // Get metodoak
    public String getIzena() {
        return izena;
    }

    public int getAdina() {
        return adina;
    }

    public char getSexua() {
        return sexua;
    }

    public float getPisua() {
        return pisua;
    }

    public float getAltuera() {
        return altuera;
    }
}
