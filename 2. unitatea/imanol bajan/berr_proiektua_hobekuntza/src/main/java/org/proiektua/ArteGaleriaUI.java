package org.proiektua;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Comparator;

public class ArteGaleriaUI extends JFrame {
    private final ArteGalería galeria = new ArteGalería();
    private DefaultTableModel model;

    // Formulario eremuak
    private final JTextField izenburuaField = new JTextField(15);
    private final JTextField artistaField = new JTextField(15);
    private final JTextField tamainaField = new JTextField(15);
    private final JTextField estiloaField = new JTextField(15);
    private final JTextField motaField = new JTextField(15);
    private final JTextField prezioaField = new JTextField(15);

    // Diru kantitatea
    private double diruKantitatea = 0.0;
    private final JLabel diruLabel = new JLabel("ASA empresa: Diru kantitatea: 0.0 €");

    public ArteGaleriaUI() {
        setTitle("Arte Galeria");
        setSize(900, 700);  // Tamaina handiagoa botoiak eta taula ondo bistaratzea lortzeko
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout-a GridBagLayout izango da
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espazio gehiago

        // Formularioa
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(formularioa(), gbc);

        // Botoiak
        gbc.gridy = 1;
        add(botoiak(), gbc);

        // Taula
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Taula zabaltzeko
        add(taulaPanel(), gbc);

        // Diru kantitatea
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(diruLabel, gbc);
    }

    private JPanel formularioa() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Datuak sartu"));
        
        panel.add(new JLabel("Izenburua:"));
        panel.add(izenburuaField);
        panel.add(new JLabel("Artista:"));
        panel.add(artistaField);

        panel.add(new JLabel("Tamaina:"));
        panel.add(tamainaField);
        panel.add(new JLabel("Estiloa:"));
        panel.add(estiloaField);

        panel.add(new JLabel("Mota:"));
        panel.add(motaField);
        panel.add(new JLabel("Prezioa:"));
        panel.add(prezioaField);

        return panel;
    }

    private JPanel botoiak() {
        JPanel botoiPanel = new JPanel(new GridLayout(1, 7, 10, 10));  // GridLayout erabilita botoiak modu egokian kokatzeko
        botoiPanel.setBorder(BorderFactory.createTitledBorder("Botoiak"));

        JButton gordeBtn = new JButton("Gorde");
        JButton salduBtn = new JButton("Saldu");
        JButton esportatuBtn = new JButton("Esportatu JSON");
        JButton kargatuBtn = new JButton("Kargatu JSON");
        JButton ordenaPrezioaAscendenteBtn = new JButton("Ordena Prezioa Ascendente");
        JButton ordenaPrezioaDescendenteBtn = new JButton("Ordena Prezioa Descendente");
        JButton ordenaArtistaAlfabetikoaBtn = new JButton("Ordena Artista Alfabeto");

        botoiPanel.add(gordeBtn);
        botoiPanel.add(salduBtn);
        botoiPanel.add(esportatuBtn);
        botoiPanel.add(kargatuBtn);
        botoiPanel.add(ordenaPrezioaAscendenteBtn);
        botoiPanel.add(ordenaPrezioaDescendenteBtn);
        botoiPanel.add(ordenaArtistaAlfabetikoaBtn);

        // Gorde botoia
        gordeBtn.addActionListener(e -> {
            String izenburua = izenburuaField.getText();
            String artista = artistaField.getText();
            String tamaina = tamainaField.getText();
            String estiloa = estiloaField.getText();
            String mota = motaField.getText();
            double prezioa = Double.parseDouble(prezioaField.getText());

            ArteLana arteLana = new ArteLana(izenburua, artista, tamaina, estiloa, mota, prezioa);
            galeria.gehituArteLana(arteLana);
            JOptionPane.showMessageDialog(this, "Arte lana gehitu da!");
            actualizarTabla(); // Taula eguneratu
        });

        // Saldu botoia
        salduBtn.addActionListener(e -> {
            String izenburua = izenburuaField.getText();
            String prezioaStr = JOptionPane.showInputDialog(this, "Zenbat eurotan salduko duzu?");
            if (prezioaStr != null && !prezioaStr.isEmpty()) {
                try {
                    double salduPrezioa = Double.parseDouble(prezioaStr);
                    galeria.salduArteLana(izenburua);
                    diruKantitatea += salduPrezioa;
                    diruLabel.setText("ASA empresa: Diru kantitatea: " + diruKantitatea + " €");
                    JOptionPane.showMessageDialog(this, "Arte lana saldu da!");
                    actualizarTabla(); // Taula eguneratu
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Sartutako prezioa ez da zuzena.");
                }
            }
        });

        // Esportatu JSON botoia
        esportatuBtn.addActionListener(e -> galeria.gordeJsonFitxategian());

        // Kargatu JSON botoia
        kargatuBtn.addActionListener(e -> {
            galeria.kargatuJsonFitxategitik();
            actualizarTabla(); // Kargatu datuak taulatik
        });

        // Ordenar por precio ascendente
        ordenaPrezioaAscendenteBtn.addActionListener(e -> {
            galeria.lortuArteLanGuztiak().sort(Comparator.comparingDouble(ArteLana::getPrezioa));
            actualizarTabla();
        });

        // Ordenar por precio descendente
        ordenaPrezioaDescendenteBtn.addActionListener(e -> {
            galeria.lortuArteLanGuztiak().sort(Comparator.comparingDouble(ArteLana::getPrezioa).reversed());
            actualizarTabla();
        });

        // Ordenar por artista alfabéticamente
        ordenaArtistaAlfabetikoaBtn.addActionListener(e -> {
            galeria.lortuArteLanGuztiak().sort(Comparator.comparing(ArteLana::getArtista));
            actualizarTabla();
        });

        return botoiPanel;
    }

    private JScrollPane taulaPanel() {
        // Taula panel
        String[] columnNames = {"Izenburua", "Artista", "Tamaina", "Estiloa", "Mota", "Prezioa"};
        model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    private void actualizarTabla() {
        model.setRowCount(0); // Garbitu taula
        for (ArteLana arteLana : galeria.lortuArteLanGuztiak()) {
            model.addRow(new Object[]{
                    arteLana.getIzenburua(),
                    arteLana.getArtista(),
                    arteLana.getTamaina(),
                    arteLana.getEstiloa(),
                    arteLana.getMota(),
                    arteLana.getPrezioa()
            });
        }
    }
}
