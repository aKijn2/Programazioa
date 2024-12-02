public class TestData1 {
    public static void main(String[] args) throws Exception {

        /**
         * Data klaseko instantzia bat sortu eta haren atributuak aldatu
         */
        Data dataEskatu = new Data();

        /**
         * Data klaseko atributuak aldatu
         */
        dataEskatu.setEguna(3);
        dataEskatu.setHilabetea(10);
        dataEskatu.setUrtea(1970);

        /**
         * Data klaseko atributuak inprimatu
         */
        System.out.println("Eguna=" + dataEskatu.getEguna());
        System.out.println("Hilabetea=" + dataEskatu.getHilabetea());
        System.out.println("Urtea=" + dataEskatu.getUrtea());
    }
}
