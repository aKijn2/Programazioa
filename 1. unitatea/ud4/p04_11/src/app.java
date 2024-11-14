public class app {
    public static void main(String[] args) {

        /**
         * Zenbakia klaseko instantzia bat sortzen du
         */
        Zenbakia zenbakia = new Zenbakia();

        /**
         * Zenbakia klaseko balioa aldatzen du nie kasuan 5 ezarri diot
         */
        zenbakia.setZenbakia(5);

        /**
         * Imprimatu zenbakia klaseko metodoak erabiliz
         */
        System.out.println("Balioa: " + zenbakia.getBalioa());
        System.out.println("Bikoitza: " + zenbakia.getBikoitza());
        System.out.println("Hirukoitza: " + zenbakia.getHirukoitza());
    }
}
