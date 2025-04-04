import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            Interfazea interfazea = new Interfazea();
            interfazea.setVisible(true);
        });
    }
}