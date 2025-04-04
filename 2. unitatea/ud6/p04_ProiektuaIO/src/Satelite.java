
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Satelite klasea, satelite baten informazioa eta funtzioak kudeatzeko.
 */
public class Satelite implements java.io.Serializable {

    private String izena;
    private int id;
    private double meridiano;
    private double paralelo;
    private double distantziaLurra;

    /**
     * Satelite berri bat sortzeko konstruktorea.
     *
     * @param izena           Satelitearen izena.
     * @param id              Satelitearen IDa.
     * @param meridiano       Satelitearen meridianoa.
     * @param paralelo        Satelitearen paraleloa.
     * @param distantziaLurra Satelitearen distantzia Lurraren azpitik.
     */
    public Satelite(String izena, int id, double meridiano, double paralelo, double distantziaLurra) {
        this.izena = izena;
        this.id = id;
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.distantziaLurra = distantziaLurra;
    }

    /**
     * Satelitearen IDa lortzen du.
     *
     * @return Satelitearen IDa.
     */
    public int getId() {
        return id;
    }

    /**
     * Satelitearen izena lortzen du.
     *
     * @return Satelitearen izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Satelitearen posizioa eguneratzen du (izena, meridianoa, paraleloa eta
     * distantzia Lurraren).
     *
     * @param izena           Satelitearen izena.
     * @param meridiano       Satelitearen meridianoa.
     * @param paralelo        Satelitearen paraleloa.
     * @param distantziaLurra Satelitearen distantzia Lurraren.
     */
    public void setPosizioa(String izena, double meridiano, double paralelo, double distantziaLurra) {
        this.izena = izena;
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.distantziaLurra = distantziaLurra;
    }

    /**
     * Satelitearen posizioa inprimatzen du.
     */
    public void printPosizioa() {
        System.out.println("ID: " + id + ", Izena: " + izena + ", Meridiano: " + meridiano + ", Paralelo: " + paralelo
                + ", Distantzia Lurra: " + distantziaLurra);
    }

    /**
     * Satelitearen altuera (distantzia Lurraren) aldatzen du.
     *
     * @param altueraBerria   Aldatu behar den altuera.
     * @param meridianoBerria Aldatu behar den meridianoa.
     * @param paraleloBerria  Aldatu behar den paraleloBerria.
     * 
     */
    public void aldatuAltuera(double altueraBerria) {
        this.distantziaLurra = altueraBerria;
    }

    public void aldatuMeridianoa(double meridianoBerria) {
        this.meridiano = meridianoBerria;
    }

    public void aldatuParaleloa(double paraleloBerria) {
        this.paralelo = paraleloBerria;
    }

    /**
     * Sateliteak orbitan dagoen edo ez egiaztatzen du.
     *
     * @return true Sateliteak orbitan badago, bestela false.
     */
    public boolean orbitanDago() {
        return this.distantziaLurra > 0;
    }

    /**
     * Satelitearen posizioa (meridianoa eta paraleloa) aldatzen du.
     *
     * @param meridiano Satelitearen meridianoa.
     * @param paralelo  Satelitearen paraleloa.
     */
    public void aldatuPosizioa(double meridiano, double paralelo) {
        this.meridiano = meridiano;
        this.paralelo = paralelo;
    }

    // Ordenatu distantzia lurra (ascendente)
    public static Comparator<Satelite> distantziaLurraOrdenaAscendente = new Comparator<Satelite>() {
        @Override
        public int compare(Satelite s1, Satelite s2) {
            return Double.compare(s1.distantziaLurra, s2.distantziaLurra);
        }
    };

    // Ordenatu distantzia lurra (descendente)
    public static Comparator<Satelite> distantziaLurraOrdenaDescendente = new Comparator<Satelite>() {
        @Override
        public int compare(Satelite s1, Satelite s2) {
            return Double.compare(s2.distantziaLurra, s1.distantziaLurra);
        }
    };

    /**
     * Sateliteak izenaren arabera ordenatzeko Comparator bat.
     */
    public static Comparator<Satelite> izenaOrdena = (s1, s2) -> s1.getIzena().compareTo(s2.getIzena());

    /**
     * Satelite bat ezabatzen du IDaren arabera.
     *
     * @param sateliteak   Ezabatu beharreko sateliteen zerrenda.
     * @param idBorratzeko Ezabatu nahi den satelitearen IDa.
     * @return Satelitea ezabatzen bada, true; bestela, false.
     */
    public static boolean borratuSatelite(ArrayList<Satelite> sateliteak, int idBorratzeko) {
        for (int i = 0; i < sateliteak.size(); i++) {
            if (sateliteak.get(i).getId() == idBorratzeko) {
                sateliteak.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Satelite baten IDa erabiliz, satelite hori bilatzen du zerrendan.
     *
     * @param sateliteak Bilatu behar den sateliteen zerrenda.
     * @param id         Satelitearen IDa.
     * @return Aurkitutako satelitea, edo null ez badago.
     */
    public static Satelite bilatuSatelitea(ArrayList<Satelite> sateliteak, int id) {
        for (Satelite satelite : sateliteak) {
            if (satelite.getId() == id) {
                return satelite;
            }
        }
        return null;
    }

    /**
     * Dagoeneko existitzen den satelite baten IDa baliozkotzen du.
     *
     * @param sateliteak Zerrenda osoa, non ID hori bilatzen den.
     * @param id         Satelitearen IDa.
     * @return true ID hori existitzen bada, bestela false.
     */
    public static boolean idBalioztatu(ArrayList<Satelite> sateliteak, int id) {
        for (Satelite satelite : sateliteak) {
            if (satelite.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Satelite guztiak inprimatzen ditu.
     *
     * @param sateliteak Sateliteen zerrenda.
     */
    public static void printSateliteak(ArrayList<Satelite> sateliteak) {
        if (sateliteak.isEmpty()) {
            System.out.println("Ez dago satelite erregistraturik.");
        } else {
            for (Satelite satelite : sateliteak) {
                satelite.printPosizioa();
            }
        }
    }

    /**
     * Int motako input bat jasotzen du erabiltzailetik, eta errorearen kasuan
     * berriro eskatzen du.
     *
     * @param sc    Scanner objektua erabiltzailetik datuak jasotzeko.
     * @param mezua Eskatuta emandako mezua.
     * @return Erabiltzaileak sartutako zenbaki osoa.
     */
    public static int jasoInt(Scanner sc, String mezua) {
        while (true) {
            System.out.print(mezua);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Errorea: Zenbaki oso bat sartu behar duzu.");
                sc.nextLine();
            }
        }
    }

    /**
     * Double motako input bat jasotzen du erabiltzailetik, eta errorearen
     * kasuan berriro eskatzen du.
     *
     * @param sc    Scanner objektua erabiltzailetik datuak jasotzeko.
     * @param mezua Eskatuta emandako mezua.
     * @return Erabiltzaileak sartutako zenbaki hamartarra.
     */
    public static double jasoDouble(Scanner sc, String mezua) {
        while (true) {
            System.out.print(mezua);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Errorea: Zenbaki bat sartu behar duzu.");
                sc.nextLine();
            }
        }
    }

    /**
     * Sateliteak gordeko ditugu .dat fitxategian.
     * Horretarako fitxategiaren izena eskatzen digu.
     * 
     * @param sateliteak Satelite zerrenda.
     * @return
     */
    public static ArrayList<Satelite> gordeSatelite(ArrayList<Satelite> sateliteak) {

        System.out.println("Sartu fitxategiaren izena .dat formatuan: ");
        String gordeIzena = new Scanner(System.in).nextLine();

        try (FileOutputStream fitxIrteera = new FileOutputStream(gordeIzena);
                ObjectOutputStream out = new ObjectOutputStream(fitxIrteera)) {

            out.writeObject(sateliteak);

            System.out.println("Datuak ondo gorde dira.");

        } catch (IOException i) {
            System.out.println("Errorea: " + i.getMessage());

        }
        return sateliteak;
    }

    /**
     * Sateliteak kargatuko ditugu .dat fitxategitik.
     * Fitxategiak kargatzeko, .dat fitxategiak bilatuko ditu eta imprimatu egingo
     * 
     * @return direktorioan dauden fitxategiak
     */
    public static ArrayList<Satelite> kargatuSatelite() {

        ArrayList<Satelite> sateliteak = new ArrayList<Satelite>();
        /**
         * Array lista bat sortuko dugu non gordeko ditugu gure programa kokapenaren
         * fitxeroan dauden fitxeroak.
         */
        File[] bilatuFitxategi = new File(".").listFiles();

        int fitxategiKopurua = 0;
        String fitxategiIzena = "";

        for (File fitxa : bilatuFitxategi) {
            if (fitxa.isFile() && fitxa.getName().endsWith(".dat")) {
                fitxategiKopurua++;
                fitxategiIzena = fitxa.getName();
            }
        }

        /**
         * Balioztatuko du fitxategi kopurua horren arabera funtzio bat beteko du edo
         * bestea
         * Fitxategi bakarra baldin badago hori kargatuko du baino bat baino gehiago
         * baldin baditugu eskatuko digu zehin kargatu nahi dugun.
         */
        if (fitxategiKopurua == 1) {
            try {
                FileInputStream fitxSarrera = new FileInputStream(fitxategiIzena);
                ObjectInputStream in = new ObjectInputStream(fitxSarrera);

                sateliteak = (ArrayList<Satelite>) in.readObject();

                in.close();
                fitxSarrera.close();

                System.out.println("Datuak ondo kargatu dira.");

            } catch (IOException i) {
                System.out.println("Ez da fitxategia aurkitu.");

            } catch (Exception e) {
                System.out.println("Errorea: " + e.getMessage());
            }

            return sateliteak;
        }

        if (fitxategiKopurua > 1) {
            System.out.println("Zure fitxategiak hauek dira: ");
            for (File fitxa : bilatuFitxategi) {
                if (fitxa.isFile() && fitxa.getName().endsWith(".dat")) {
                    System.out.println(fitxa.getName());
                }
            }

            System.out.println("Zein fitxategi kargatu nahi duzu?");
            String aukera = new Scanner(System.in).nextLine();

            try {
                FileInputStream fitxSarrera = new FileInputStream(aukera);
                ObjectInputStream in = new ObjectInputStream(fitxSarrera);

                sateliteak = (ArrayList<Satelite>) in.readObject();

                in.close();
                fitxSarrera.close();

                System.out.println("Datuak ondo kargatu dira.");

            } catch (IOException i) {
                System.out.println("Ez da fitxategia aurkitu.");

            } catch (Exception e) {
                System.out.println("Errorea: " + e.getMessage());
            }
            return sateliteak;

        } else {
            System.out.println("Ez da fitxategirik aurkitu.");
        }
        return sateliteak;
    }
}
