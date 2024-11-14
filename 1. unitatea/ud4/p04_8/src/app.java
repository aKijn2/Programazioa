public class app {
    public static void main(String[] args) {

        /**
         * Finantza klaseko histantzia bat sortu eta metodoak probatu
         */
        Finantza finantzaLehenetsia = new Finantza();

        /**
         * Metodoak probatu
         */
        System.out.println("10 dolar eurotara: " + finantzaLehenetsia.dolarToEuro(10));
        System.out.println("10 euro dolarreta: " + finantzaLehenetsia.euroToDolar(10));

        /**
         * Finantza klaseko histantzia bat sortu eta metodoak probatu, kasu honetan 1.20
         * balorearekin ezarrita
         */
        Finantza finantzaPertsonalizatua = new Finantza(1.20);

        /**
         * Metodoak probatu
         */
        System.out.println("10 dolar eurotara: " + finantzaPertsonalizatua.dolarToEuro(10));
        System.out.println("10 euro dolarreta: " + finantzaPertsonalizatua.euroToDolar(10));
    }
}