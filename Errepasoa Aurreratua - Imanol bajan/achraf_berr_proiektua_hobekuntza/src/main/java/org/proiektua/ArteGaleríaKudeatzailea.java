package org.proiektua;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;

/**
 * Erabiltzailearen interakzioak eta menu sistema kudeatzen ditu.
 */
public class ArteGaleríaKudeatzailea 
{
    private final ArteGalería galeria = new ArteGalería();
    private final Scanner teklatua = new Scanner(System.in);

    /**
     * Menu nagusia erakusten du eta erabiltzailearen sarrera kudeatzen du.
     */
    public void erakutsiMenua() 
    {
        while (true) 
        {
            System.out.println("\n=== Arte Galeria Kudeatu ===");
            System.out.println("1. Gehitu Arte Lana");
            System.out.println("2. Saldu Arte Lana");
            System.out.println("3. Bilatu Artistaren Arabera");
            System.out.println("4. Bilatu Motaren Arabera");
            System.out.println("5. Bilatu Prezioaren Arabera");
            System.out.println("6. Ikusi Arte Lan Guztiak");
            System.out.println("7. Gorde .json fitxategian");
            System.out.println("8. Kargatu .json fitxategitik");
            System.out.println("0. Irten");
            System.out.print("Aukeratu aukera bat: ");

            int aukera = teklatua.nextInt();
            teklatua.nextLine();

            /**
             * Menuaren aukera kudeatzen du.
             * Erabiltzaileak aukeratutako aukera exekutatzen du.
             * Aukera okerra bada, mezua erakusten du eta berriro saiatzen da.
             */
            switch (aukera) 
            {
                case 1 -> gehituArteLana();
                case 2 -> salduArteLana();
                case 3 -> bilatuArtistarenArabera();
                case 4 -> bilatuMotarenArabera();
                case 5 -> bilatuPrezioarenArabera();
                case 6 -> erakutsiArteLanGuztiak();
                case 7 -> gordeJsonFitxategian();
                case 8 -> kargatuJsonFitxategitik();
                case 0 -> 
                {
                    System.out.println("Irtetzen...");
                    return;
                }
                default -> System.out.println("Aukera okerra. Saiatu berriro.");
            }
        }
    }

    /**
     * Arte lana gehitzeko metodoa.
     * Erabiltzaileak arte lanaren datuak sartzen ditu eta galeriara gehitzen du.
     */
    private void gehituArteLana() 
    {
        System.out.println("\nSartu arte lanaren datuak:");

        System.out.print("Izenburua: ");
        String izenburua = teklatua.nextLine();

        System.out.print("Artista: ");
        String artista = teklatua.nextLine();

        System.out.print("Tamaina (adib., 24x36 hazbeteko): ");
        String tamaina = teklatua.nextLine();

        System.out.print("Estiloa: ");
        String estiloa = teklatua.nextLine();

        System.out.print("Mota: ");
        String mota = teklatua.nextLine();

        System.out.print("Prezioa: €");
        double prezioa = teklatua.nextDouble();

        galeria.gehituArteLana(new ArteLana(izenburua, artista, tamaina, estiloa, mota, prezioa));
        System.out.println("Arte lana ondo gehitu da!");
    }

    /**
     * Arte lana saldu edo ezabatzeko metodoa.
     * Erabiltzaileak arte lanaren izenburua sartzen du eta galeriatik kentzen du.
     */
    private void salduArteLana() 
    {
        System.out.print("\nSartu saldu nahi den arte lanaren izenburua: ");
        String izenburua = teklatua.nextLine();
        galeria.salduArteLana(izenburua);

        System.out.println("Arte lana saldu/ezabatu da.");
    }

    /**
     * Arte lanak artistaren arabera bilatzeko metodoa.
     * Erabiltzaileak artistaren izena sartzen du eta galeriako arte lanak bilatzen ditu.
     */
    private void bilatuArtistarenArabera() 
    {
        System.out.print("\nSartu artistaren izena: ");
        String artista = teklatua.nextLine();
        erakutsiEmaitzak(galeria.bilatuArtistarenArabera(artista));
    }

    /**
     * Arte lanak motaren arabera bilatzeko metodoa.
     * Erabiltzaileak arte lanaren motaren izena sartzen du eta galeriako arte lanak bilatzen ditu.
     */
    private void bilatuMotarenArabera() 
    {
        System.out.print("\nSartu arte lan mota: ");
        String mota = teklatua.nextLine();
        erakutsiEmaitzak(galeria.bilatuMotarenArabera(mota));
    }

    /**
     * Arte lanak prezioaren arabera bilatzeko metodoa.
     * Erabiltzaileak prezioa sartzen du eta galeriako arte lanak bilatzen ditu.
     * Prezio maximoa zehaztuten du, 100 ezartzen badugu 100 =< erakutsiko du.
     */
    private void bilatuPrezioarenArabera() 
    {
        System.out.print("\nSartu gehienezko prezioa: €");
        double prezioa = teklatua.nextDouble();
        erakutsiEmaitzak(galeria.bilatuPrezioarenArabera(prezioa));
    }

    /**
     * Arte lan guztiak erakusteko metodoa.
     * Galerian dauden arte lan guztiak erakusten ditu.
     * Baldintza betetzen baldin bada mezua hitzuliko du esanez hutsik dagoela.
     * Bestela arte lan guztiak erakutsiko ditu.
     */
    private void erakutsiArteLanGuztiak() 
    {
        List<ArteLana> arteLanGuztiak = galeria.lortuArteLanGuztiak();

        if (arteLanGuztiak.isEmpty()) 
        {
            System.out.println("\nEz dago arte lanik galerian.");
        } else 
        {
            System.out.println("\nArte Lan Guztiak:");
            System.out.println("|----------------------------------------------|");
            System.out.println("|Izenburua|Artista|Tamaina|Estiloa|Mota|Prezioa|");
            System.out.println("|----------------------------------------------|");
            erakutsiEmaitzak(arteLanGuztiak);
        }
    }

    /**
     * Arte lanen emaitzak erakusteko metodoa.
     * Erabiltzaileak bilatutako arte lanen zerrenda erakusten du.
     * @param arteLanak Bilatutako arte lanen zerrenda
     * Baldintza betetzen baldin bada mezua hitzuliko du esanez hutsik dagoela.
     * Bestela arte lan guztiak erakutsiko ditu.
     */
    private void erakutsiEmaitzak(List<ArteLana> arteLanak) 
    {
        if (arteLanak.isEmpty()) 
        {
            System.out.println("Ez da bat datorren arte lanik aurkitu.");
            return;
        }
        for (ArteLana arteLana : arteLanak) 
        {
            arteLana.imprimatuDatuak();
        }
    }

    /**
     * Arte lanak .json fitxategian gordetzeko metodoa.
     * Galerian dauden arte lan guztiak .json fitxategian gordetzen ditu.
     * 
     * Jackson liburutegia erabiltzen da .json fitxategia sortzeko.
     * ObjectMapper klasea erabiltzen da arte lanen zerrenda .json fitxategian gordetzeko.
     */
    private void gordeJsonFitxategian() 
    {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try 
        {
            objectWriter.writeValue(new File("arte_lanak.json"), galeria.lortuArteLanGuztiak());
            System.out.println("Arte lanak .json fitxategian gorde dira.");
        } catch (IOException e) 
        {
            System.out.println("Errorea .json fitxategia gordetzean: " + e.getMessage());
        }
    }

    /**
     * Arte lanak .json fitxategitik kargatzeko metodoa.
     * .json fitxategitik arte lanen zerrenda kargatzen du eta galeriara gehitzen du.
     * 
     * Jackson liburutegia erabiltzen da .json fitxategia irakurtzeko.
     * ObjectMapper klasea erabiltzen da arte lanen zerrenda .json fitxategitik irakurtzeko.
     * TypeReference klasea erabiltzen da arte lanen zerrenda deserializatzeko.
     */
    private void kargatuJsonFitxategitik() 
    {

        ObjectMapper objectMapper = new ObjectMapper();

        try 
        {
            List<ArteLana> arteLanak = objectMapper.readValue(new File("arte_lanak.json"),
                    new TypeReference<List<ArteLana>>() 
                    {});
            galeria.gehituArteLanak(arteLanak);
            
            System.out.println("Arte lanak .json fitxategitik kargatu dira.");
        } catch (IOException e) 
        {
            System.out.println("Errorea .json fitxategia kargatzean: " + e.getMessage());
        }
    }
}