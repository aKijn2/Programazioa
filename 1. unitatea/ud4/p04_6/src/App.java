class Kotxe {

    /**
     * Kotxearen abiadura atributua
     */
    private int abiadura;

    /**
     * Kotxearen konstruktorea.
     */
    Kotxe() {
        abiadura = 0;
    }

    /**
     * Kotxearen abiadura itzultzen du.
     * 
     * @return Kotxearen abiadura
     */
    int getAbiadura() {
        return abiadura;
    }

    /**
     * Kotxearen abiadura aldatzen du.
     * 
     * @param v Aldatu nahi den abiadura
     */
    void azeleratu(int v) {
        abiadura += v;
    }

    /**
     * Kotxearen abiadura murrizten du.
     * 
     * @param z Murriztu nahi den abiadura
     */
    void balazta(int z) {
        abiadura -= z;
    }
}