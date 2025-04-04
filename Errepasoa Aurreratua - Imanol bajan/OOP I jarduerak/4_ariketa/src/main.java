import java.time.LocalDateTime;
import java.util.Scanner;

public class main 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        EguraldiDatuak eguraldiDatuak = new EguraldiDatuak();

        // A) Uneko datuak erakutsi
        Eguraldia unekoEguraldia = eguraldiDatuak.getUnekoEguraldia();
        System.out.println("Uneko eguraldia: " + unekoEguraldia);

        // B) Tenperatura maximoa, minimoa eta euri kantitate totala erakutsi
        double tenperaturaMax = Double.MIN_VALUE;
        double tenperaturaMin = Double.MAX_VALUE;
        double euriTotala = 0;

        for (Eguraldia eguraldia : eguraldiDatuak.getDatuak()) 
        {
            if (eguraldia.getTenperatura() > tenperaturaMax) 
            {
                tenperaturaMax = eguraldia.getTenperatura();
            }

            if (eguraldia.getTenperatura() < tenperaturaMin) 
            {
                tenperaturaMin = eguraldia.getTenperatura();
            }

            euriTotala += eguraldia.getEuriMm();
        }
        System.out.println("Tenperatura maximoa: " + tenperaturaMax);
        System.out.println("Tenperatura minimoa: " + tenperaturaMin);
        System.out.println("Euri kantitate totala: " + euriTotala);

        /**
         * C) Erabiltzaileari egun bat eskatu eta egun horretako tenperatura maximoa eta
         * minimoa eta euri kantitate totala erakutsi
         */
        System.out.print("Sartu egun bat (formatua: yyyy-MM-dd): ");
        String egunaInput = scanner.nextLine();

        LocalDateTime eguna = LocalDateTime.parse(egunaInput + "T00:00:00");
        
        double tenperaturaMaxEguna = Double.MIN_VALUE;
        double tenperaturaMinEguna = Double.MAX_VALUE;
        double euriTotalaEguna = 0;

        for (Eguraldia eguraldia : eguraldiDatuak.getDatuak()) 
        {
            if (eguraldia.getOrdua().toLocalDate().equals(eguna.toLocalDate())) 
            {
            if (eguraldia.getTenperatura() > tenperaturaMaxEguna) 
            {
                tenperaturaMaxEguna = eguraldia.getTenperatura();
            }
            if (eguraldia.getTenperatura() < tenperaturaMinEguna) 
            {
                tenperaturaMinEguna = eguraldia.getTenperatura();
            }
            euriTotalaEguna += eguraldia.getEuriMm();
            }
        }
        System.out.println("Egun horretako tenperatura maximoa: " + tenperaturaMaxEguna);
        System.out.println("Egun horretako tenperatura minimoa: " + tenperaturaMinEguna);
        System.out.println("Egun horretako euri kantitate totala: " + euriTotalaEguna + " mm");

        /**
         * D) Tenperatura maximo bat eskatu eta zein data/orduetan gertatu den
         * tenperatura hori baino altuago erakutsi
         */
        System.out.print("Sartu tenperatura maximo bat: ");
        double temperaturaMaximoa = scanner.nextDouble();

        System.out.println("Tenperatura hori baino altuagoak:");

        for (Eguraldia eguraldia : eguraldiDatuak.getDatuak()) 
        {
            if (eguraldia.getTenperatura() > temperaturaMaximoa) 
            {
                System.out.println(eguraldia.getOrdua() + " Tenperatura: " + eguraldia.getTenperatura());
            }
        }

        // E) Haize norantza bat eskatu eta zein data/orduetan gertatu den erakutsi
        System.out.print("Sartu haize norantza (IPAR, HEGO, EKIALDE, MENDEBALDE): ");
        String haizeNorantza = scanner.next();

        Eguraldia.HaizeNorantza haizeaNorantza = Eguraldia.HaizeNorantza.valueOf(haizeNorantza.toUpperCase());
        System.out.println("Haize norantza hori izan duten datak/orduak:");

        for (Eguraldia eguraldia : eguraldiDatuak.getDatuak()) 
        {
            if (eguraldia.getHaizeNorantza() == haizeaNorantza) 
            {
                System.out.println(eguraldia.getOrdua() + " Haize norantza: " + eguraldia.getHaizeNorantza());
            }
        }
    }
}