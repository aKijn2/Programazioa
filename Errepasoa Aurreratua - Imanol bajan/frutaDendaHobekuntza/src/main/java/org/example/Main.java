package org.example;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        /* Programa funtzio ahal izateko hurrengo agidua idatza terminalean:
         * mvn clean install
         *
         * Ez valdin badu funtzoinatzen probadu hurrengo agindua (-U forzatu egingo du):
         * mvn clean install -U
         *
         * Terminalean gure programaren root karpetan egon beharko dugu.
         */
        SwingUtilities.invokeLater(() ->
        {
            Interfazea interfazea = new Interfazea();
            interfazea.setVisible(true);
        });
    }
}