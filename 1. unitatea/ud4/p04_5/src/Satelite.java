public class Satelite {

        /**
         * Atributuak
         */
        private double meridiano;
        private double paralelo;
        private double ditantzia_lurra;

        /**
         * Eraikitzailea
         * 
         * @param m meridianoa
         * @param p paraleloa
         * @param d ditantzia_lurra
         */
        Satelite(double m, double p, double d) {
                meridiano = m;
                paralelo = p;
                ditantzia_lurra = d;
        }

        /**
         * Eraikitzailea
         */
        Satelite() {
                meridiano = paralelo = ditantzia_lurra = 0;
        }

        /**
         * Metodoak
         * 
         * @param m meridianoa
         * @param p paraleloa
         * @param d ditantzia_lurra
         */
        public void setPosicion(double m, double p, double d) {
                meridiano = m;
                paralelo = p;
                ditantzia_lurra = d;
        }

        /**
         * Metodoak non imprimiratuko du meridiano, paralelo eta ditantzia_lurra
         */
        public void printPosicion() {
                System.out.println("Satelitea honako kokapenean dago: paraleloa " + paralelo +
                                ", Meridiano " + meridiano +
                                " eta lurretik " + ditantzia_lurra + " kilometro");
        }
}
