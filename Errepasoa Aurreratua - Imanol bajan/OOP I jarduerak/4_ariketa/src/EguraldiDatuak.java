import java.util.ArrayList;

public class EguraldiDatuak {
    private ArrayList<Eguraldia> datuak;
    private Eguraldia unekoEguraldia;

    public EguraldiDatuak() {
        datuak = new ArrayList<>();
    }

    // Metodoak
    public void gehituDatuak(Eguraldia eguraldia) {
        datuak.add(eguraldia);
        unekoEguraldia = eguraldia; // Azken datua unekoa da
    }

    // Geterrak
    public Eguraldia getUnekoEguraldia() {
        return unekoEguraldia;
    }

    public ArrayList<Eguraldia> getDatuak() {
        return datuak;
    }
}
