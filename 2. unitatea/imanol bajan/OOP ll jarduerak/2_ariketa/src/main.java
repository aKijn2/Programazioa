import java.util.Scanner;

public class main 
{
    public static void main(String[] args) throws Exception 
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Sartu zirkunferentziaren erradioa: ");
        int erradioa = sc.nextInt();

        zirkunferentzia zirkunfKalk = new zirkunferentzia(erradioa);

        System.out.println("Zirkunferentziaren azalera: " + zirkunfKalk.azaleraKalkulatu());
        System.out.println("Zirkunferentziaren perimetroa: " + zirkunfKalk.perimetroaKalkulatu());
    }
}
