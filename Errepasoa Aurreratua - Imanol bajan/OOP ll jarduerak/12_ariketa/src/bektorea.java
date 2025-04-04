public class bektorea {
    private int x;
    private int y;
    private int z;

/**
 * bektoreak Konstruktorea
 *
 * @param x
 * @param y
 * @param z
 */
public bektorea(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }

// seterrak
        public void setX(int x)
        {
            this.x = x;
        }

        public void setY(int y)
        {
            this.y = y;
        }

        public void setZ(int z)
        {
            this.z = z;
        }

// getterrak
        public int getX()
        {
            return this.x;
        }

        public int getY()
        {
            return this.y;
        }

        public int getZ()
        {
            return this.z;
        }

    /**
     * Metodo honek egiten duena da zenbaki bat jaso eta bektore bat itzuliko du
     * @param zenbakia
     * @return
     */
    public bektorea zenbakiaPasaBektorea(int zenbakia)
        {
            if (zenbakia == 1)
            {
                return new bektorea(this.x, this.y, this.z);
            }
            else if (zenbakia == 2)
            {
                return new bektorea(this.y, this.z, this.x);
            }
            else
            {
                return new bektorea(this.z, this.x, this.y);
            }
        }

        public bektorea bektoreaJasoBatuketaVueltatu(bektorea bektorea)
        {
            return new bektorea(this.x + bektorea.getX(), this.y + bektorea.getY(), this.z + bektorea.getZ());
        }
}
