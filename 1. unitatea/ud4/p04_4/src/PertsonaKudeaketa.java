public class PertsonaKudeaketa {

    public static void main(String[] args) {

        /**
         * Pertsona klasea sortu balore batzuk ezarrita
         */
        Pertsona p1 = new Pertsona(22, "Koldo", 12);

        /**
         * Pertsona klaseko atributuak aldatu
         */
        p1.setGeneroa("E");

        /**
         * Bigarren pertsona sortu eta baloreak ezarri
         */
        Pertsona p2 = new Pertsona(33, "Lutxi", 34, "F");

        /**
         * Pertsonen datuak pantailaratu (getters erabiliz)
         */
        System.out.print("id: " + p1.getIdPertsona() + " Izena: " + p1.getIzena() + " Adina: " + p1.getAdina());
        System.out.println(" Generoa: " + p1.getGeneroa());
        System.out.println("id: " + p2.getIdPertsona() + " Izena: " + p2.getIzena() + " Adina: "
                + p2.getAdina() + " Generoa: " + p2.getGeneroa());
    }
}
