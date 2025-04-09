package org.proiektua;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArteGaleriaUI().setVisible(true);
        });
    }
}
