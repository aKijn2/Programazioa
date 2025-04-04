import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

                int[] zenbakiak = {1,2,3,4,5,6,-1,0,-2,-3};

                int positiboak = 0, negatiboak = 0, zeroak = 0;
                int positiboenBatura = 0, negatiboenBatura = 0;
        
                System.out.println("Sartu 10 zenbaki:");
                for(int i = 0; i < zenbakiak.length; i++){
                    if(zenbakiak[i] > 0){
                        positiboak++;
                        positiboenBatura += zenbakiak[i];
                    }else if(zenbakiak[i] < 0){
                        negatiboak++;
                        negatiboenBatura += zenbakiak[i];
                    }else{
                        zeroak++;
                    }
                }
                System.out.println("Positiboak: " + positiboak);
                System.out.println("Negatiboak: " + negatiboak);
                System.out.println("Zeroak: " + zeroak);

                System.out.println("Positiboen batura: " + positiboenBatura);
                System.out.println("Negatiboen batura: " + negatiboenBatura);
            }
}
