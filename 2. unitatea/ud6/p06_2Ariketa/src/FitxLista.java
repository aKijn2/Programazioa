import java.io.File;

public class FitxLista {

    /**
     * Programak egingo duena izango da listatu guk sairtzen diogun direkzioa. Nire
     * kasuan ez neukan eklipse eta sartu diot c:\\ bakarrik eta listatu egiten du
     * 
     * @param args
     */
    public static void main(String args[]) {
        File f = new File("./"); // jarri diot direkzio erlatiboa karpeta hau listatzeko
        File[] lista = f.listFiles();
        for (int i = 0; i < lista.length; i++)
            System.out.println(lista[i]);
    }
}
