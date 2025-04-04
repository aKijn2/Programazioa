import java.util.ArrayList;

public class App 
{
    public static void main(String[] args) throws Exception 
    {

        /**
         * Arraylist bat sortuko du
         */
        ArrayList<Integer> zenbakiak = new ArrayList<>();

        /**
         * Bost zenbaki geitzen dugu
         */
        zenbakiak.add(1);
        zenbakiak.add(2);
        zenbakiak.add(3);
        zenbakiak.add(4);
        zenbakiak.add(5);

        /**
         * Arraylisteko elementuak alderantziz 
         */

        for (int i = zenbakiak.size() - 1; i >= 0; i--) 
        {
            System.out.println(zenbakiak.get(i));
        }
    }
}