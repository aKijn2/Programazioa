public class Kontua {
    private String titularra;
    private double kopurua;

    // Titularrarekin soilik eraikitzailea
    public Kontua(String titularra) {
        this.titularra = titularra;
        this.kopurua = 0;
    }

    // Titular eta kopuruarekin eraikitzailea
    public Kontua(String titularra, double kopurua) {
        this.titularra = titularra;
        this.kopurua = kopurua;
    }

    // Titularraren getter-a
    public String getTitularra() {
        return titularra;
    }

    // Titularraren setter-a
    public void setTitularra(String titularra) {
        this.titularra = titularra;
    }

    // Kopuruaren getter-a
    public double getKopurua() {
        return kopurua;
    }

    // Kopuruaren setter-a
    public void setKopurua(double kopurua) {
        this.kopurua = kopurua;
    }

    // toString metodoa
    @Override
    public String toString() {
        return "Kontua{" +
                "titularra='" + titularra + '\'' +
                ", kopurua=" + kopurua +
                '}';
    }

    // Sartu (depositatu) kopurua metodoa
    public void sartu(double kopurua) {
        if (kopurua > 0) {
            this.kopurua += kopurua;
        }
    }

    // Atera (erretiratu) kopurua metodoa
    public void atera(double kopurua) {
        if (this.kopurua - kopurua < 0) {
            this.kopurua = 0;
        } else {
            this.kopurua -= kopurua;
        }
    }
}