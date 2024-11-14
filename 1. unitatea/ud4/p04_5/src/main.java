public class main {

    public static void main(String[] args) {

        /**
         * Satelite objektua sortu balorehekin zehaztuta
         */
        Satelite satelite = new Satelite(10.0, 20.0, 1000.0);

        /**
         * Satelitearen kokapena inprimatu
         */
        satelite.printPosicion();

        /**
         * Satelitearen kokapena eguneratu
         */
        satelite.setPosicion(15.0, 25.0, 1500.0);

        /**
         * Satelitearen kokapena inprimatu
         */
        satelite.printPosicion();
    }
}