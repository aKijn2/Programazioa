package org.proiektua;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ArteGaleriaInterfazea extends JFrame {
    public ArteGaleriaInterfazea() {
        konfiguratuFramea();
        konfiguratuPanelak();
        fitxategiaGorde();
        fitxategiaKargatu();
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
        herdikoPanelak();
        eskuinekoPanelak();
        behekoPanelak();
    }

    private void herdikoPanelak() {

        JPanel herdikoPanel = new JPanel();
        herdikoPanel.setBounds(0, 0, 600, 600);
        herdikoPanel.setLayout(null);
        herdikoPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        add(herdikoPanel);

        JButton gordeAldaketak = new JButton("Gorde aldaketak");
        gordeAldaketak.setBounds(10, 10, 150, 30);
        gordeAldaketak.setBackground(java.awt.Color.WHITE);
        gordeAldaketak.setForeground(java.awt.Color.black);
        gordeAldaketak.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        gordeAldaketak.setFocusPainted(false);
        gordeAldaketak.setBorderPainted(false);
        gordeAldaketak.setOpaque(true);

        gordeAldaketak.addActionListener(e -> {
            fitxategiaGorde();
        });
        herdikoPanel.add(gordeAldaketak);

        JLabel izenburuLabel = new JLabel("Sartu izenburua: ");
        izenburuLabel.setBounds(10, 50, 200, 30);
        izenburuLabel.setForeground(java.awt.Color.black);
        izenburuLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(izenburuLabel);

        JTextField izenburuTextField = new JTextField();
        izenburuTextField.setBounds(220, 50, 200, 30);
        izenburuTextField.setBackground(java.awt.Color.WHITE);
        izenburuTextField.setForeground(java.awt.Color.black);
        izenburuTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        izenburuTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(izenburuTextField);

        JLabel artistLabel = new JLabel("Sartu artistaren izena: ");
        artistLabel.setBounds(10, 100, 200, 30);
        artistLabel.setForeground(java.awt.Color.black);
        artistLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(artistLabel);

        JTextField artistTextField = new JTextField();
        artistTextField.setBounds(220, 100, 200, 30);
        artistTextField.setBackground(java.awt.Color.WHITE);
        artistTextField.setForeground(java.awt.Color.black);
        artistTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        artistTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(artistTextField);

        JLabel tamainLabel = new JLabel("Sartu tamaina: ");
        tamainLabel.setBounds(10, 150, 200, 30);
        tamainLabel.setForeground(java.awt.Color.black);
        tamainLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(tamainLabel);

        JTextField tamainaJTextField = new JTextField();
        tamainaJTextField.setBounds(220, 150, 200, 30);
        tamainaJTextField.setBackground(java.awt.Color.WHITE);
        tamainaJTextField.setForeground(java.awt.Color.black);
        tamainaJTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        tamainaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(tamainaJTextField);

        JLabel estiloLabel = new JLabel("Sartu estiloa: ");
        estiloLabel.setBounds(10, 200, 200, 30);
        estiloLabel.setForeground(java.awt.Color.black);
        estiloLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(estiloLabel);

        JTextField estiloaJTextField = new JTextField();
        estiloaJTextField.setBounds(220, 200, 200, 30);
        estiloaJTextField.setBackground(java.awt.Color.WHITE);
        estiloaJTextField.setForeground(java.awt.Color.black);
        estiloaJTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        estiloaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(estiloaJTextField);

        JLabel motaLabel = new JLabel("Sartu mota: ");
        motaLabel.setBounds(10, 250, 200, 30);
        motaLabel.setForeground(java.awt.Color.black);
        motaLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(motaLabel);

        JTextField motaJTextField = new JTextField();
        motaJTextField.setBounds(220, 250, 200, 30);
        motaJTextField.setBackground(java.awt.Color.WHITE);
        motaJTextField.setForeground(java.awt.Color.black);
        motaJTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        motaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(motaJTextField);

        JLabel prezioaLabel = new JLabel("Sartu mota: ");
        prezioaLabel.setBounds(10, 300, 200, 30);
        prezioaLabel.setForeground(java.awt.Color.black);
        prezioaLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        herdikoPanel.add(prezioaLabel);

        JTextField prezioaJTextField = new JTextField();
        prezioaJTextField.setBounds(220, 300, 200, 30);
        prezioaJTextField.setBackground(java.awt.Color.WHITE);
        prezioaJTextField.setForeground(java.awt.Color.black);
        prezioaJTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        prezioaJTextField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        herdikoPanel.add(prezioaJTextField);
    }

    private void eskuinekoPanelak() {
        JPanel eskunekoPanel = new JPanel();
        eskunekoPanel.setBounds(0, 0, 200, 600);
        eskunekoPanel.setLayout(null);
        eskunekoPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        add(eskunekoPanel);
    }

    private void behekoPanelak() {
        JPanel behekoPanel = new JPanel();
        behekoPanel.setBounds(0, 0, 600, 100);
        behekoPanel.setLayout(null);
        behekoPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        add(behekoPanel);
    }

    private void fitxategiaGorde() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("artegaleria.json"), this);
            System.out.println("Fitxategia gorde da.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fitxategiaKargatu() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ArteGaleriaInterfazea artegaleria = objectMapper.readValue(new File("artegaleria.json"), ArteGaleriaInterfazea.class);
            System.out.println("Fitxategia kargatu da.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
