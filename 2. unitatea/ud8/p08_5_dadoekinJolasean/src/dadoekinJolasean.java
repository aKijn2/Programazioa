import javax.swing.*;
import java.awt.*;

public class dadoekinJolasean 
{

    private static final JFrame frame = new JFrame("DADO JAURTIKETA");
    private static final JPanel panela = new JPanel(new GridBagLayout());

    public static void main(String[] args) throws Exception 
    {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel dadokopuruaLabela = new JLabel("Sartu zenbat dado nahi dituzun:");
        JLabel aldeKopuruaLabela = new JLabel("Sartu zenbat alde nahi dituzun:");
        JLabel guztiarenBatura = new JLabel("Guztiaren batura: ");

        JTextField dadoKopuruaTextField = new JTextField(10);
        JTextField aldeKopuruaJTextField = new JTextField(10);
        JTextArea erantzunaJTextArea = new JTextArea(5, 20);

        JButton jaurtiBotoia = new JButton("JAURTI");

        /**
         * ActionListener bat non enter botoia sakatzean jaurti botoia sakatu egiten duen.
         */
        dadoKopuruaTextField.addActionListener(e -> jaurtiBotoia.doClick());
        aldeKopuruaJTextField.addActionListener(e -> jaurtiBotoia.doClick());

        /**
         * Botoiaren kolorea aldatzen dugu sagua sartu eta atera egiten dugunean.
         */
        jaurtiBotoia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jaurtiBotoia.setBackground(new java.awt.Color(205, 205, 205));
                jaurtiBotoia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jaurtiBotoia.setBackground(new java.awt.Color(255, 255, 255));
                jaurtiBotoia.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        jaurtiBotoia.addActionListener(e -> 
        {
            erantzunaJTextArea.setText("");

            try 
            {
                erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                int dadoKopurua = Integer.parseInt(dadoKopuruaTextField.getText());
                int aldeKopurua = Integer.parseInt(aldeKopuruaJTextField.getText());

                /**
                 * Dado kopurua eta alde kopurua 1 baino handiagoa izan behar da.
                 * 
                 * Alde kopurua 4, 6, 10 edo 20 izan behar da.
                 * 
                 * Bestela gorriz markatuko digu jarea eta errorea mezua botako digu.
                 */
                if (dadoKopurua < 1 || aldeKopurua < 1) 
                {
                    erantzunaJTextArea.setText("Dado kopurua eta alde kopurua 1 baino handiagoa izan behar da");
                    erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    return;
                }
                
                if (aldeKopurua != 4 && aldeKopurua != 6 && aldeKopurua != 10 && aldeKopurua != 20) 
                {
                    erantzunaJTextArea.setText("Alde kopurua 4, 6, 10 edo 20 izan behar da");
                    erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    return;
                }

                for (int i = 0; i < dadoKopurua; i++) 
                
                {
                    /**
                     * Dado kopurua 10 baino handiagoa bada, zenbakiak komatxo batekin banandu bestela hutsune batekin banandu.
                     */
                    if (dadoKopurua > 10) 
                    {
                        int balioa = (int) (Math.random() * aldeKopurua) + 1;
                        erantzunaJTextArea.append(balioa + ", ");
                        erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                    } 
                    else
                    {
                        int balioa = (int) (Math.random() * aldeKopurua) + 1;
                        erantzunaJTextArea.append(balioa + " ");
                        erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                    }

                    // Dado guztiran batura kalkulatzen dugu.
                    int dadoGuztiranBatura = 0;
                    
                    for (int j = 0; j < dadoKopurua; j++) 
                    {
                        dadoGuztiranBatura += (int) (Math.random() * aldeKopurua) + 1;
                    } 
                    guztiarenBatura.setText("Guztiaren batura: " + dadoGuztiranBatura);
                }
            } catch (NumberFormatException ex) 
            {
                erantzunaJTextArea.setText("Mesedez, sartu zenbaki baliodunak.");
                erantzunaJTextArea.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
        });

        /*
         * Panelaren kolorea eta erantzunaren kolorea aldatu.
         */
        panela.setBackground(new java.awt.Color(43, 43, 43));
        erantzunaJTextArea.setLineWrap(true);
        erantzunaJTextArea.setEditable(false);
        erantzunaJTextArea.setBackground(new java.awt.Color(255, 255, 255));

        dadokopuruaLabela.setForeground(new java.awt.Color(255, 255, 255));
        aldeKopuruaLabela.setForeground(new java.awt.Color(255, 255, 255));
        guztiarenBatura.setForeground(new java.awt.Color(255, 255, 255));
        jaurtiBotoia.setBackground(new java.awt.Color(255, 255, 255));


        /**
         * GridBagLayout erabiliz panelaren elementuak kokatzen ditugu nuk sartutako posizioan arabera.
         */
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(4, 6, 4, 6);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.anchor = GridBagConstraints.EAST;
        panela.add(dadokopuruaLabela, grid);

        grid.gridx = 1;
        grid.anchor = GridBagConstraints.CENTER;
        panela.add(dadoKopuruaTextField, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        grid.anchor = GridBagConstraints.EAST;
        panela.add(aldeKopuruaLabela, grid);

        grid.gridx = 1;
        grid.anchor = GridBagConstraints.CENTER;
        panela.add(aldeKopuruaJTextField, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 2;
        grid.anchor = GridBagConstraints.CENTER;
        panela.add(jaurtiBotoia, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 2;
        grid.anchor = GridBagConstraints.CENTER;
        panela.add(guztiarenBatura, grid);

        grid.gridy = 3;
        grid.fill = GridBagConstraints.BOTH;
        panela.add(new JScrollPane(erantzunaJTextArea), grid);

        /**
         * Frame-a sortu eta panela gehitu.
         */
        frame.add(panela);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
