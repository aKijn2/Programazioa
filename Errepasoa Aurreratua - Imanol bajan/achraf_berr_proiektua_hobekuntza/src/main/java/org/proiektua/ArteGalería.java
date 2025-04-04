package org.proiektua;

import java.util.ArrayList;
import java.util.List;

/**
 * Arte galeriako arte lanen bilduma kudeatzen du.
 */
public class ArteGalería 
{

    private final List<ArteLana> arteLanak = new ArrayList<>();

    /**
     * Arte lana gehitzen du galeriara.
     *
     * @param arteLana Gehitu bearreko arte lana
     */
    public void gehituArteLana(ArteLana arteLana) 
    {
        arteLanak.add(arteLana);
    }

    /**
     * Arte lana kentzen du izenburuaren arabera.
     *
     * @param izenburua Kendu bearreko arte lanaren izenburua
     */
    public void salduArteLana(String izenburua) 
    {
        for (int i = 0; i < arteLanak.size(); i++) 
        {
            if (arteLanak.get(i).getIzenburua().equalsIgnoreCase(izenburua)) 
            {
                arteLanak.remove(i);
                break;
            }
        }
    }

    /**
     * Arte lanak bilatzen ditu artistaren arabera.
     *
     * @param artista Bilatu bearreko artistaren izena
     * @return Bat datozen arte lanen zerrenda
     */
    public List<ArteLana> bilatuArtistarenArabera(String artista) 
    {
        List<ArteLana> emaitza = new ArrayList<>();
        for (ArteLana arteLana : arteLanak) 
        {
            if (arteLana.getArtista().equalsIgnoreCase(artista)) 
            {
                emaitza.add(arteLana);
            }
        }
        return emaitza;
    }

    /**
     * Arte lanak bilatzen ditu motaren arabera.
     *
     * @param mota Bilatu bearreko arte lan mota
     * @return Bat datozen arte lanen zerrenda
     */
    public List<ArteLana> bilatuMotarenArabera(String mota) 
    {
        List<ArteLana> emaitza = new ArrayList<>();
        for (ArteLana arteLana : arteLanak) 
        {
            if (arteLana.getMota().equalsIgnoreCase(mota)) 
            {
                emaitza.add(arteLana);
            }
        }
        return emaitza;
    }

    /**
     * Arte lanak bilatzen ditu prezioaren arabera.
     *
     * @param gehienezkoPrezioa Prezio maximoa
     * @return Arte lanen zerrenda itultzen digu
     */
    public List<ArteLana> bilatuPrezioarenArabera(double gehienezkoPrezioa) 
    {
        List<ArteLana> emaitza = new ArrayList<>();
        for (ArteLana arteLana : arteLanak) 
        {
            if (arteLana.getPrezioa() <= gehienezkoPrezioa) 
            {
                emaitza.add(arteLana);
            }
        }
        return emaitza;
    }

    /**
     * Galeriako arte lan guztiak eskuratzen ditu.
     *
     * @return Arte lan guztien zerrenda
     */
    public List<ArteLana> lortuArteLanGuztiak() 
    {
        return new ArrayList<>(arteLanak);
    }

    /**
     * Gehitu arte lanen zerrenda galerian.
     * 
     * @param arteLanak Arte lanen zerrenda
     */
    public void gehituArteLanak(List<ArteLana> arteLanak) 
    {
        for (ArteLana arteLana : arteLanak) 
        {
            gehituArteLana(arteLana); // Assuming gehituArteLana(ArteLana) exists
        }
    }
}
