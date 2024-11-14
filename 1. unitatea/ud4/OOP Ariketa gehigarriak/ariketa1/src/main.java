public class main {

    public static void main(String[] args) {

        // Sortu kontu bat titular eta kopuruarekin
        Kontua kontua1 = new Kontua("Juan", 1000);
        // Sortu kontu bat titularrarekin (kopuru lehenetsia 0 izango da)
        Kontua kontua2 = new Kontua("Pepe");

        // Dirua sartzen dugu kontuetan
        kontua1.sartu(300);
        kontua2.sartu(400);

        // Dirua ateratzen dugu kontuetan
        kontua1.atera(500);
        kontua2.atera(100);

        System.out.println(kontua1); 
        System.out.println(kontua2);
    }
}
