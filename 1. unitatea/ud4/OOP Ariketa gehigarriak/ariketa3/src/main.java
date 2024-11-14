import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        pasahitza p = new pasahitza(8, "12345678");

        System.out.println("Sartu pasahitza: ");
        String pasahitza = sc.nextLine();

        if (pasahitza.equals(p.getPasahitza())) {
            System.out.println("Pasahitza zuzena da.");
        } else {
            System.out.println("Pasahitza okerra da.");
        }

        sc.close();
    }
}
