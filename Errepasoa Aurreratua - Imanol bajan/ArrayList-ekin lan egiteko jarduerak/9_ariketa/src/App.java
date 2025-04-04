import java.util.ArrayList;

public class App 
{
    public static void main(String[] args) throws Exception 
    {

        /**
         * Arraylist bat sortuko du
         */
        ArrayList<Integer> zenbakiak = new ArrayList<>();
        ArrayList<Integer> handiak = new ArrayList<>();

        /**
         * Zenbakiak geitzen dugu
         */
        zenbakiak.add(10);
        zenbakiak.add(25);
        zenbakiak.add(30);
        zenbakiak.add(15);
        zenbakiak.add(50);

        /**
         * Baldintza betetzen duten elementuak transferitu
         */
        for (int i = 0; i < zenbakiak.size(); i++) 
        {
            if (zenbakiak.get(i) > 20) 
            {
                handiak.add(zenbakiak.get(i));
            }
        }

        /**
         * Bigarren Arraylist imprimatu
         */
        for (int i = 0; i < handiak.size(); i++) 
        {
            System.out.println(handiak.get(i));
        }
    }
}
