import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * Satelitearen datuak gordeko dituen array list bat.
         */
        ArrayList<Satelite> sateliteak = new ArrayList<>();

        /**
         * While bukle bat dugu non beti errepikatuko da true dan bitartean.
         */
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1. Sortu satelitea      -");
            System.out.println("2. Kokapena inprimatu   -");
            System.out.println("3. Kudeatu satelitea    -");
            System.out.println("4. Orbitan dago         -");
            System.out.println("5. Borratu satelitea    -");
            System.out.println("6. Borratu guztia       -");
            System.out.println("7. Irten                -");
            System.out.println("8. Gorde datuak         -");
            System.out.println("9. Kargatu datuak       -");
            System.out.println("-------------------------");

            int aukera = Satelite.jasoInt(sc, "Aukeratu zenbaki bat: ");

            /**
             * Identifikatzeko ID bat behar dugu, hau da, satelitea identifikatzeko.
             */
            int id;

            /**
             * Aukera bakoitzean bere funtzioa du, lehenengo aukeran satelitea sortzen
             * ditugu
             * Bere datuekin.
             * 
             * Eta besteak dira datuak kudeatzeko, imprimatzeko eta programa amaitzeko.
             */
            switch (aukera) {
                case 1:
                    int sateliteIda;
                    do {
                        sateliteIda = Satelite.jasoInt(sc, "Sartu satelitearen IDa: ");
                        if (Satelite.idBalioztatu(sateliteak, sateliteIda)) {
                            System.out.println("Errorea: ID hori duten satelitea existitzen da. Saiatu berriro.");
                        }

                        boolean idBaliozkoa;
                        do {
                            idBaliozkoa = true;
                            if (sateliteIda <= 0) {
                                System.out.println("Errorea: IDa ezin daiteke 0 baino txikiagoa izan.");
                                idBaliozkoa = false;
                            }

                        } while (!idBaliozkoa);

                    } while (Satelite.idBalioztatu(sateliteak, sateliteIda));

                    sc.nextLine();
                    String izena;

                    System.out.print("Satelitearen izena: ");
                    izena = sc.nextLine();

                    double meridiano = Satelite.jasoDouble(sc, "Sartu meridianoa: ");
                    double paralelo = Satelite.jasoDouble(sc, "Sartu paraleloa: ");
                    double ditantziaLurra = Satelite.jasoDouble(sc, "Sartu distantzia Lurra: ");

                    Satelite satelite = new Satelite(izena, sateliteIda, meridiano, paralelo, ditantziaLurra);
                    sateliteak.add(satelite);
                    break;

                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("1. Distantzia lurra (ascendente)      -");
                    System.out.println("2. Distantzia lurra (descendente)     -");
                    System.out.println("3. Izenaren arabera (alfabetikoki)    -");
                    System.out.println("---------------------------------------");

                    int opcionOrden = Satelite.jasoInt(sc, "Aukeratu zenbaki bat: ");
                    switch (opcionOrden) {
                        case 1:
                            sateliteak.sort(Satelite.distantziaLurraOrdenaAscendente);
                            break;
                        case 2:
                            sateliteak.sort(Satelite.distantziaLurraOrdenaDescendente);
                            break;
                        case 3:
                            sateliteak.sort(Satelite.izenaOrdena);
                            break;
                        default:
                            System.out.println("Aukera okerra");
                            break;
                    }
                    Satelite.printSateliteak(sateliteak);
                    break;

                case 3:
                    id = Satelite.jasoInt(sc, "Sartu satelitearen IDa: ");
                    Satelite sateliteAldaketak = Satelite.bilatuSatelitea(sateliteak, id);

                    if (sateliteAldaketak != null) {
                        System.out.println("---------------------------");
                        System.out.println("1. Posizio osoa aldatu    -");
                        System.out.println("2. Altuera aldatu         -");
                        System.out.println("3. Meridiano aldatu       -");
                        System.out.println("4. Paraleloa aldatu       -");
                        System.out.println("---------------------------");

                        int aldaketakAukera = Satelite.jasoInt(sc, "Aukeratu zer aldatu nahi duzun: ");
                        switch (aldaketakAukera) {
                            case 1:
                                double meridianoEguneratu = Satelite.jasoDouble(sc, "Sartu meridianoa: ");
                                double paraleloEguneratu = Satelite.jasoDouble(sc, "Sartu paraleloa: ");
                                double distantziaLurraEguneratu = Satelite.jasoDouble(sc, "Sartu distantzia Lurra: ");

                                sateliteAldaketak.setPosizioa(sateliteAldaketak.getIzena(), meridianoEguneratu,
                                        paraleloEguneratu, distantziaLurraEguneratu);
                                break;

                            case 2:
                                double altueraBerria = Satelite.jasoDouble(sc,
                                        "Sartu altuera aldatzeko zenbaki bat: ");
                                sateliteAldaketak.aldatuAltuera(altueraBerria);
                                break;

                            case 3:
                                double meridianoBerria = Satelite.jasoDouble(sc, "Sartu meridianoa: ");
                                sateliteAldaketak.aldatuMeridianoa(meridianoBerria);
                                break;

                            case 4:
                                double paraleloBerria = Satelite.jasoDouble(sc, "Sartu paraleloa: ");
                                sateliteAldaketak.aldatuParaleloa(paraleloBerria);
                                break;
                        }
                    } else {
                        System.out.println("Satelitea ez da aurkitu");
                    }
                    break;

                case 4:
                    id = Satelite.jasoInt(sc, "Sartu satelitearen IDa: ");
                    Satelite sateliteaOrbitandago = Satelite.bilatuSatelitea(sateliteak, id);

                    if (sateliteaOrbitandago != null) {
                        System.out.println("Orbitan dago: " + sateliteaOrbitandago.orbitanDago());
                    } else {
                        System.out.println("Satelitea ez da aurkitu");
                    }
                    break;

                case 5:
                    System.out.print("Sartu satelitearen IDa ezabatzeko: ");
                    int idBorratzeko = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ziur al zaude satelite hau ezabatu nahi duzula? (Bai/Ez): ");
                    String onartu = sc.nextLine();

                    if (onartu.equalsIgnoreCase("Bai")) {
                        if (Satelite.borratuSatelite(sateliteak, idBorratzeko)) {
                            System.out.println("Satelitea ID " + idBorratzeko + " ezabatua izan da.");
                        } else {
                            System.out.println("Satelite hori ez da aurkitu.");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Ziur al zaude guztiak ezabatu nahi dituzula? (Bai/Ez): ");
                    sc.nextLine();
                    onartu = sc.nextLine();

                    if (onartu.equalsIgnoreCase("Bai")) {
                        sateliteak.clear();
                        System.out.println("Guztiak ezabatu dira.");

                    } else {
                        System.out.println("Ez da ezer ezabatu.");
                    }
                    break;

                case 7:
                    System.out.println("Programatik irten zara.");

                    sc.close();
                    return;

                case 8:
                    Satelite.gordeSatelite(sateliteak);
                    break;

                case 9:
                    sateliteak = Satelite.kargatuSatelite();
                    break;

                default:
                    System.out.println("Aukera ez da zuzena. Saiatu berriro.");
            }
        }
    }

}
