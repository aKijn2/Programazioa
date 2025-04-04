package org.proiektua;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArteGaleriaInterfazea extends JFrame {
    private final List<ArteLana> arteLanak = new ArrayList<>();
    private DefaultTableModel tableModel;

    public ArteGaleriaInterfazea() {
        this.tableModel = new DefaultTableModel();
        konfiguratuFramea();
        konfiguratuPanelak();
    }

    private void konfiguratuFramea() {
        setTitle("Arte Galeria Interfazea");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void konfiguratuPanelak() {
        JPanel herdikoPanel = new JPanel();
        herdikoPanel.setBounds(0, 0, 600, 600);
        herdikoPanel.setLayout(null);
        herdikoPanel.setBackground(Color.LIGHT_GRAY);
        add(herdikoPanel);

        JLabel izenburuLabel = new JLabel("Sartu izenburua:");
        izenburuLabel.setBounds(10, 10, 200, 30);
        herdikoPanel.add(izenburuLabel);

        JTextField izenburuTextField = new JTextField();
        izenburuTextField.setBounds(220, 10, 200, 30);
        herdikoPanel.add(izenburuTextField);

        JLabel artistLabel = new JLabel("Sartu artistaren izena:");
        artistLabel.setBounds(10, 50, 200, 30);
        herdikoPanel.add(artistLabel);

        JTextField artistTextField = new JTextField();
        artistTextField.setBounds(220, 50, 200, 30);
        herdikoPanel.add(artistTextField);

        JLabel tamainLabel = new JLabel("Sartu tamaina:");
        tamainLabel.setBounds(10, 90, 200, 30);
        herdikoPanel.add(tamainLabel);

        JTextField tamainaTextField = new JTextField();
        tamainaTextField.setBounds(220, 90, 200, 30);
        herdikoPanel.add(tamainaTextField);

        JLabel estiloLabel = new JLabel("Sartu estiloa:");
        estiloLabel.setBounds(10, 130, 200, 30);
        herdikoPanel.add(estiloLabel);

        JTextField estiloTextField = new JTextField();
        estiloTextField.setBounds(220, 130, 200, 30);
        herdikoPanel.add(estiloTextField);

        JLabel motaLabel = new JLabel("Sartu mota:");
        motaLabel.setBounds(10, 170, 200, 30);
        herdikoPanel.add(motaLabel);

        JTextField motaTextField = new JTextField();
        motaTextField.setBounds(220, 170, 200, 30);
        herdikoPanel.add(motaTextField);

        JLabel prezioaLabel = new JLabel("Sartu prezioa:");
        prezioaLabel.setBounds(10, 210, 200, 30);
        herdikoPanel.add(prezioaLabel);

        JTextField prezioaTextField = new JTextField();
        prezioaTextField.setBounds(220, 210, 200, 30);
        herdikoPanel.add(prezioaTextField);

        JButton gordeButton = new JButton("Gorde aldaketak");
        gordeButton.setBounds(10, 250, 150, 30);
        herdikoPanel.add(gordeButton);

        JButton erakutsiButton = new JButton("Erakutsi datuak");
        erakutsiButton.setBounds(170, 250, 150, 30);
        herdikoPanel.add(erakutsiButton);

        JButton esportatuButton = new JButton("Esportatu JSON");
        esportatuButton.setBounds(330, 250, 150, 30);
        herdikoPanel.add(esportatuButton);

        // Table to display data
        String[] columnNames = { "Izenburua", "Artista", "Tamaina", "Estiloa", "Mota", "Prezioa" };
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 300, 570, 200);
        herdikoPanel.add(scrollPane);

        gordeButton.addActionListener(e -> {
            try {
                String izenburua = izenburuTextField.getText();
                String artista = artistTextField.getText();
                String tamaina = tamainaTextField.getText();
                String estiloa = estiloTextField.getText();
                String mota = motaTextField.getText();
                double prezioa = Double.parseDouble(prezioaTextField.getText());

                ArteLana arteLana = new ArteLana(izenburua, artista, tamaina, estiloa, mota, prezioa);
                arteLanak.add(arteLana);
                gordeJson();
                JOptionPane.showMessageDialog(this, "Datuak ondo gorde dira!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Errorea datuak gordetzean: " + ex.getMessage());
            }
        });

        erakutsiButton.addActionListener(e -> {
            tableModel.setRowCount(0);
            for (ArteLana arteLana : arteLanak) {
                tableModel.addRow(new Object[] {
                        arteLana.getIzenburua(),
                        arteLana.getArtista(),
                        arteLana.getTamaina(),
                        arteLana.getEstiloa(),
                        arteLana.getMota(),
                        arteLana.getPrezioa()
                });
            }
        });

        esportatuButton.addActionListener(e -> {
            try {
                gordeJson();
                JOptionPane.showMessageDialog(this, "JSON fitxategia esportatu da!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Errorea JSON esportatzean: " + ex.getMessage());
            }
        });
    }

    private void gordeJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("artegaleria.json"), arteLanak);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArteGaleriaInterfazea interfazea = new ArteGaleriaInterfazea();
            interfazea.setVisible(true);
        });
    }
}
