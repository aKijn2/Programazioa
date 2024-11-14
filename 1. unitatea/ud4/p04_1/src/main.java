public class main {
    public static void main(String[] args) {

        // Ezartzen diogu balorea Ikaslea klasean definitutako metodoetan.
        Ikaslea ikasle1 = new Ikaslea("Ane", 18);
        Ikaslea ikasle2 = new Ikaslea("Jon", 21);

        // Ikasleak pantailaratzen ditugu.
        System.out.println("Izena: " + ikasle1.getIzena() + " Adina: " + ikasle1.getAdina());
        System.out.println("Izena: " + ikasle2.getIzena() + " Adina: " + ikasle2.getAdina());
    }
}
