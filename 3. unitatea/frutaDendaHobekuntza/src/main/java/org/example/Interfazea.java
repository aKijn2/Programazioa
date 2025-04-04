package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;

public class Interfazea extends JFrame
{
    private ArrayList<Fruta> frutak;
    private DefaultListModel<String> erosketaZerrenda;
    private JLabel guztiraLabel;
    private double guztiraPrezioa = 0.0; // Prezio totala (zergarik gabe)

    /**
     * FrutaInterfazearen eraikitzailea.
     */
    public Interfazea()
    {
        konfiguratuFramea();
        hasieratuFrutak();
        konfiguratuPanela();
    }

    /**
     * Leio nagusia konfiguratzeko metodoa.
     */
    private void konfiguratuFramea()
    {
        setTitle("Fruta Denda");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    /**
     * Fruten datuak hasieratzen ditu.
     */
    private void hasieratuFrutak()
    {
        frutak = new ArrayList<>();
        frutak.add(new Fruta("Limoia", "irudiak/limoia.jpg", 2.5, 10));
        frutak.add(new Fruta("Sagarra", "irudiak/sagarra.jpg", 1.8, 20));
        frutak.add(new Fruta("Laranja", "irudiak/laranja.jpg", 2.0, 15));
        frutak.add(new Fruta("Sandia", "irudiak/sandia.jpg", 4.5, 80));
        frutak.add(new Fruta("Meloia", "irudiak/meloia.jpg", 3.8, 60));
        frutak.add(new Fruta("Fresak", "irudiak/fresak.jpg", 3.0, 25));
    }

    /**
     * Interfaz osoko panelak konfiguratzeko metodoa.
     */
    private void konfiguratuPanela()
    {
        gehituErdikoPanela();
        gehituEskuinekoPanela();
    }

    /**
     * Erosketa panela (erdiko panela) frutak erakusteko.
     */
    private void gehituErdikoPanela()
    {
        JPanel erdikoPanela = new JPanel();

        erdikoPanela.setLayout(new GridLayout(0, 3, 10, 10));
        erdikoPanela.setBorder(new EmptyBorder(20, 20, 20, 20));
        erdikoPanela.setBackground(new Color(240, 240, 240));

        for (Fruta fruta : frutak)
        {
            JPanel frutaPanela = sortuFrutaPanela(fruta);
            erdikoPanela.add(frutaPanela);
        }

        JScrollPane skrollPanela = new JScrollPane(erdikoPanela);

        skrollPanela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        skrollPanela.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(skrollPanela, BorderLayout.CENTER);
    }

    /**
     * JPanel bat sortu eta konfiguratzen du fruta zehatz bat irudikatzeko.
     * 
     * - Panelak fruituaren irudia, izena, prezioa, stocken kudeaketa ditu,
     * - Erosi beharreko kantitatea zehazteko testu eremuan kantitatea jarri behar da.
     *
     * @param fruta Informazioa duen fruta objektua.
     * 
     */

    private JPanel sortuFrutaPanela(Fruta fruta)
    {
        JPanel panela = new JPanel();
        panela.setLayout(new BoxLayout(panela, BoxLayout.Y_AXIS));
        panela.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        panela.setBackground(Color.WHITE);

        JLabel irudia = new JLabel();
        ImageIcon imageIcon = new ImageIcon(fruta.getIrudia());
        Image scaledImage = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        irudia.setIcon(new ImageIcon(scaledImage));
        irudia.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel izena = new JLabel(fruta.getIzena());
        izena.setFont(new Font("Arial", Font.BOLD, 14));
        izena.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel prezioa = new JLabel("Prezioa: " + fruta.getPrezioa() + " €/kg");
        prezioa.setFont(new Font("Arial", Font.PLAIN, 12));
        prezioa.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel stock = new JLabel("Stock: " + fruta.getStock() + " kg");
        stock.setFont(new Font("Arial", Font.PLAIN, 12));
        stock.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField kantitateaField = new JTextField();
        kantitateaField.setMaximumSize(new Dimension(80, 25));
        kantitateaField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton gehituBotoia = new JButton("Gehitu");
        gehituBotoia.setAlignmentX(Component.CENTER_ALIGNMENT);
        gehituBotoia.setBackground(Color.WHITE);
        gehituBotoia.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                gehituBotoia.setBackground(new Color(200, 200, 200));
            }

            public void mouseExited(MouseEvent evt)
            {
                gehituBotoia.setBackground(Color.WHITE);
            }
        });

        /**
         * Gehitu botoian klik egitean erosketa logika exekutatzen du:
         *
         * - Srartutako kantitatea irakurtzen eta balioztatzen du.
         * - Prezioa kalkulatu eta guztira eguneratzen du.
         * - Frutaren stock-a murrizten du.
         * - Erosketa zerrendan gehitzen du eta interfazea berritzen du.
         * - Erroreak kudeatzen ditu (sarrera baliogabea edo kantitate okerrak).
         *
         * @param e Botoiaren ekintzaren ondoriozko ActionEvent.
         */
        gehituBotoia.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int kantitatea = Integer.parseInt(kantitateaField.getText());

                    if (kantitatea > 0 && kantitatea <= fruta.getStock())
                    {
                        double prezioaGuztira = kantitatea * fruta.getPrezioa();
                        guztiraPrezioa += prezioaGuztira;
                        fruta.setStock(fruta.getStock() - kantitatea);
                        erosketaZerrenda.addElement(fruta.getIzena() + " - " + kantitatea + " kg - " + prezioaGuztira + " €");
                        guztiraLabel.setText("Guztira (Beza-kin): " + (guztiraPrezioa * 1.21) + " €");
                        stock.setText("Stock: " + fruta.getStock() + " kg");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panela, "Kantitatea ez da egokia.", "Errorea", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(panela, "Kantitatea zenbaki oso bat izan behar da.", "Errorea", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panela.add(irudia);
        panela.add(Box.createRigidArea(new Dimension(0, 5)));
        panela.add(izena);
        panela.add(prezioa);
        panela.add(stock);
        panela.add(Box.createRigidArea(new Dimension(0, 5)));
        panela.add(kantitateaField);
        panela.add(Box.createRigidArea(new Dimension(0, 5)));
        panela.add(gehituBotoia);

        return panela;
    }

    /**
     * Eskuineko panela erosketen zerrenda eta guztizko prezioa erakusteko.
     * Ezabatzeko botoia gehituz.
     */
    private void gehituEskuinekoPanela()
    {
        JPanel eskuinekoPanela = new JPanel();
        eskuinekoPanela.setLayout(new BorderLayout());
        eskuinekoPanela.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel goiburua = new JLabel("Erosketa Zerrenda");
        goiburua.setFont(new Font("Arial", Font.BOLD, 16));
        eskuinekoPanela.add(goiburua, BorderLayout.NORTH);

        erosketaZerrenda = new DefaultListModel<>();
        JList<String> erosketakLista = new JList<>(erosketaZerrenda);
        JScrollPane scrollPane = new JScrollPane(erosketakLista);
        eskuinekoPanela.add(scrollPane, BorderLayout.CENTER);

        // Botoia frutak kentzeko listatk.
        JButton ezabatuBotoia = new JButton("Kendu");
        ezabatuBotoia.setBackground(new Color(244, 67, 54));
        ezabatuBotoia.setForeground(Color.WHITE);
        ezabatuBotoia.setFocusPainted(false);
        ezabatuBotoia.setAlignmentX(Component.CENTER_ALIGNMENT);

        ezabatuBotoia.addActionListener(e ->
        {
            int aukeratutakoLista = erosketakLista.getSelectedIndex();
            if (aukeratutakoLista != -1)
            {
                String hautatutakoElementua = erosketaZerrenda.getElementAt(aukeratutakoLista);
                erosketaZerrenda.remove(aukeratutakoLista);

                // Prezio guztia eguneratu
                String[] zatitua = hautatutakoElementua.split(" - ");
                double kenduPrezioa = Double.parseDouble(zatitua[2].replace(" €", ""));
                guztiraPrezioa -= kenduPrezioa;
                guztiraLabel.setText("Guztira (Beza-kin): " + (guztiraPrezioa * 1.21) + " €");

                // Eguneratu stocka ezabatuBotoia ematerakoan
                String[] zatitua2 = zatitua[0].split(" ");
                for (Fruta fruta : frutak)
                {
                    if (fruta.getIzena().equals(zatitua2[0]))
                    {
                        fruta.setStock(fruta.getStock() + Integer.parseInt(zatitua[1].replace(" kg", "")));
                        erosketaZerrenda.addElement(fruta.getIzena() + " - " + zatitua2 + " kg - " + zatitua2 + " €");
                        guztiraLabel.setText("Guztira (Beza-kin): " + (guztiraPrezioa * 1.21) + " €");
                        Label stock = null;
                        stock.setText("Stock: " + fruta.getStock() + " kg");

                    }
                }
            } else
            {
                JOptionPane.showMessageDialog(this, "Ez duzu produkturik hautatu!", "Errorea", JOptionPane.ERROR_MESSAGE);
            }
        });

        // imprimatu gordetako lista eta prezioa botoia
        JButton gordeBotoia = new JButton("Gorde");
        gordeBotoia.setBackground(new Color(76, 175, 80));
        gordeBotoia.setForeground(Color.WHITE);
        gordeBotoia.setFocusPainted(false);
        gordeBotoia.setAlignmentX(Component.CENTER_ALIGNMENT);

        gordeBotoia.addActionListener(e ->
        {
            try {
                ObjectWriter jsonGorde = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = jsonGorde.writeValueAsString(frutak);

                try (FileWriter file = new FileWriter("datuak.json")) {
                    file.write(json);
                }

                JOptionPane.showMessageDialog(this, "Datuak ongi gorde dira.", "Informazioa", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(this, "Errorea fitxategia gordetzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Kargatu botoia datuak kargatzeko
        JButton kargatuBotoia = new JButton("Kargatu");
        kargatuBotoia.setBackground(new Color(76, 175, 80));
        kargatuBotoia.setForeground(Color.WHITE);
        kargatuBotoia.setFocusPainted(false);
        kargatuBotoia.setAlignmentX(Component.CENTER_ALIGNMENT);

        kargatuBotoia.addActionListener(event ->
        {
            ObjectMapper jsonIdatzi = new ObjectMapper();
            try {
                Fruta[] frutak = jsonIdatzi.readValue(new File("datuak.json"), Fruta[].class);
                for (Fruta fruta : frutak) {
                    this.frutak.add(fruta);

                    // eguneratu erosketaZerreanda
                    erosketaZerrenda.addElement(fruta.getIzena() + " - " + fruta.getStock() + " kg - " + fruta.getPrezioa() + " €");
                }
                JOptionPane.showMessageDialog(this, "Datuak ongi kargatu dira.", "Informazioa", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(this, "Errorea fitxategia kargatzean: " + ex.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Label-a eta botoia gehitu
        guztiraLabel = new JLabel("Guztira (Beza-kin): 0.0 €");
        guztiraLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel behekoPanela = new JPanel();
        behekoPanela.setLayout(new BoxLayout(behekoPanela, BoxLayout.Y_AXIS));
        behekoPanela.add(guztiraLabel);
        behekoPanela.add(Box.createRigidArea(new Dimension(0, 10)));
        behekoPanela.add(ezabatuBotoia);
        behekoPanela.add(Box.createRigidArea(new Dimension(5, 5)));
        behekoPanela.add(gordeBotoia);
        behekoPanela.add(Box.createRigidArea(new Dimension(5, 5)));
        behekoPanela.add(kargatuBotoia);

        eskuinekoPanela.add(behekoPanela, BorderLayout.SOUTH);

        add(eskuinekoPanela, BorderLayout.EAST);
    }
}