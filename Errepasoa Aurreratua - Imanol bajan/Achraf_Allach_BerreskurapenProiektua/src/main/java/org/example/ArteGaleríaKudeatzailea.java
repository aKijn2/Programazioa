package org.example;

import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.DataOutput;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("7. Gorde json fitxategian");
            System.out.println("8. Kargatu json fitxategia");
            System.out.println("0. Irten");
            System.out.print("Aukeratu aukera bat: ");

            int aukera = teklatua.nextInt();
            teklatua.nextLine();

            switch (aukera) 
            {
                case 1 -> gehituArteLana();
                case 2 -> salduArteLana();
                case 3 -> bilatuArtistarenArabera();
                case 4 -> bilatuMotarenArabera();
                case 5 -> bilatuPrezioarenArabera();
                case 6 -> erakutsiArteLanGuztiak();
                case 7 -> gordeJsonFitxategian();
                case 8 -> kargatuJsonFitxategia();
                case 0 -> {
                    System.out.println("Sistematik irteten...");
                    return;
                }
                default -> System.out.println("Aukera okerra. Saiatu berriro.");
            }
        }
    }

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

    private void salduArteLana() 
    {
        System.out.print("\nSartu saldu nahi den arte lanaren izenburua: ");
        String izenburua = teklatua.nextLine();
        galeria.salduArteLana(izenburua);

        System.out.println("Arte lana saldu/ezabatu da.");
    }

    private void bilatuArtistarenArabera() 
    {
        System.out.print("\nSartu artistaren izena: ");   
        String artista = teklatua.nextLine();
        erakutsiEmaitzak(galeria.bilatuArtistarenArabera(artista));
    }

    private void bilatuMotarenArabera() 
    {
        System.out.print("\nSartu arte lan mota: ");
        String mota = teklatua.nextLine();
        erakutsiEmaitzak(galeria.bilatuMotarenArabera(mota));
    }

    private void bilatuPrezioarenArabera() 
    {
        System.out.print("\nSartu gehienezko prezioa: €");
        double prezioa = teklatua.nextDouble();
        erakutsiEmaitzak(galeria.bilatuPrezioarenArabera(prezioa));
    }

    private void erakutsiArteLanGuztiak() 
    {
        List<ArteLana> arteLanGuztiak = galeria.lortuArteLanGuztiak();
        if (arteLanGuztiak.isEmpty()) 
        {
            System.out.println("\nEz dago arte lanik galerian.");
        } else 
        {
            System.out.println("\nArte Lan Guztiak:");
            erakutsiEmaitzak(arteLanGuztiak);
        }
    }

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
            System.out.println();
        }
    }

    private void gordeJsonFitxategian()
    {
        try
        {
            ObjectWriter writer = galeria.gordeJsonFitxategian();
            writer.writeValue((DataOutput) galeria, System.out);
            System.out.println("Arte lanak ondo gorde dira.");
        }
        catch (Exception e)
        {
            System.out.println("Errorea gertatu da arte lanak gordetzean.");
        }
    }

    private void kargatuJsonFitxategia()
    {
        try
        {
            galeria.kargatuJsonFitxategia();
            System.out.println("Arte lanak ondo kargatu dira.");
        }
        catch (Exception e)
        {
            System.out.println("Errorea gertatu da arte lanak kargatzean.");
        }
    }


}