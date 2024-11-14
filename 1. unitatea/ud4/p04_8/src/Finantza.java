public class Finantza {
    private double trukeTasa;

    // Lehenetsitako eraikitzailea
    public Finantza() {
        this.trukeTasa = 1.36;
    }

    // Parametro bat hartzen duen eraikitzailea
    public Finantza(double tasa) {
        this.trukeTasa = tasa;
    }

    // Metodoa dolarrak eurotara bihurtzeko
    public double dolarToEuro(double dolar) {
        return dolar / trukeTasa;
    }

    // Metodoa euroak dolarreta bihurtzeko
    public double euroToDolar(double euro) {
        return euro * trukeTasa;
    }
}