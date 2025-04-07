import java.time.LocalDateTime;

public class Eguraldia {
    private LocalDateTime ordua;
    private double tenperatura;
    private HaizeNorantza haizeNorantza;
    private double euriMm;
    private ZeruEgoera zeruEgoera;

    // Konstruktorea
    public Eguraldia(LocalDateTime ordua, double tenperatura, HaizeNorantza haizeNorantza, double euriMm,
            ZeruEgoera zeruEgoera) {
        this.ordua = ordua;
        this.tenperatura = tenperatura;
        this.haizeNorantza = haizeNorantza;
        this.euriMm = euriMm;
        this.zeruEgoera = zeruEgoera;
    }

    // Geterrak
    public LocalDateTime getOrdua() {
        return ordua;
    }

    public double getTenperatura() {
        return tenperatura;
    }

    public HaizeNorantza getHaizeNorantza() {
        return haizeNorantza;
    }

    public double getEuriMm() {
        return euriMm;
    }

    public ZeruEgoera getZeruEgoera() {
        return zeruEgoera;
    }

    // Metodoak
    @Override
    public String toString() {
        return "Eguraldia{" +
                "ordua=" + ordua +
                ", tenperatura=" + tenperatura +
                ", haizeNorantza=" + haizeNorantza +
                ", euriMm=" + euriMm +
                ", zeruEgoera=" + zeruEgoera +
                '}';
    }

    // Enumerazioak
    public enum HaizeNorantza {
        IPAR, HEGO, EKIALDE, MENDEBALDE
    }

    public enum ZeruEgoera {
        OSKARBI, ERDI_LAINOTURIK, HODEITSU, EURITSU
    }
}
