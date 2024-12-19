import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

public class KudeatuPrograma {
    public static void main(String[] args) throws Exception {

        do {
            System.err.println("            MENUA          ");
            System.out.println("1. Erregistroa zerrendatu  ");
            System.out.println("2. Erregistroa bat gehitu  ");
            System.out.println("3. Izenaren arabera bilatu ");
            System.out.println("4. Programa amaitu         ");

            Scanner sc = new Scanner(System.in);

            int aukera = sc.nextInt();

            switch (aukera) {
                case 1:
                    TaulaDB t = new TaulaDB("datuak.dat");
                    int erregKop = t.getErregistroaKop();
                    for (int i = 1; i <= erregKop; i++) {
                        Erregistroa r = t.irakurriErregistroa(i);
                        System.out.println(r.erakutsiErregistroa());
                    }
                    t.itxiTaula();
                    break;
                case 2:
                    System.out.println("Sartu izena");
                    String izena = sc.next();

                    System.out.println("Sartu adina");
                    int adina = sc.nextInt();

                    System.out.println("Sartu pisua");
                    double pisua = sc.nextDouble();

                    TaulaDB t2 = new TaulaDB("datuak.dat");

                    t2.idatziErregistroa(izena, adina, pisua, t2.getErregistroaKop() + 1);
                    t2.itxiTaula();

                    for (int i = 1; i <= t2.getErregistroaKop(); i++) {
                        Erregistroa r = t2.irakurriErregistroa(i);
                        System.out.println(r.erakutsiErregistroa());
                    }

                    break;
                case 4:
                    System.out.println("Programa amaitu da");
                    return;
                default:
                    System.out.println("Aukera okerra");
                    break;
            }
        } while (true);
    }
}