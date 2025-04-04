import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Transakzioak {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }
        jarriElementuak();
    }

    static final int MIN = 0;
    static final int MAX = 1000;
    static final int INIT = 0;

    private static JLabel label = new JLabel("1 Euro dolar zenbatekoa:");
    private static JLabel lblEuroak = new JLabel("Euro:");
    private static JLabel lblDolarrak = new JLabel("Dolar:");
    private static JFrame frame = new JFrame("Transakzioa Euro - Dolare");
    private static JPanel panel1 = new JPanel();
    private static JPanel panel2 = new JPanel();
    private static JPanel panel3 = new JPanel();
    private static JTextField txtEuro = new JTextField("0");
    private static JTextField txtDolar = new JTextField("0");
    private static JTextField txtAldaketa = new JTextField("1.36");
    private static JSlider sliderDolar = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
    private static JSlider sliderEuro = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);

    public static void aldatuTextua(FocusEvent e) {
        if (e.getSource() == txtEuro) {
            float iAldaketa = Float.parseFloat(txtEuro.getText());
            iAldaketa = 100 * iAldaketa * Float.parseFloat(txtAldaketa.getText());
            iAldaketa = Math.round(iAldaketa);
            iAldaketa = iAldaketa / 100;
            txtEuro.setText(String.valueOf(iAldaketa));
            // aldatu slider
            sliderEuro.setValue(Math.round(Float.parseFloat(txtEuro.getText())));
        }

        if (e.getSource() == txtDolar) {
            float iAldaketa = Float.parseFloat(txtDolar.getText());
            iAldaketa = 100 * iAldaketa / Float.parseFloat(txtAldaketa.getText());
            iAldaketa = Math.round(iAldaketa);
            iAldaketa = iAldaketa / 100;
            txtDolar.setText(String.valueOf(iAldaketa));
            // aldatu slider
            sliderDolar.setValue(Math.round(Float.parseFloat(txtDolar.getText())));

        }
    }

    public static void mugituSlider(ChangeEvent e) {
        int balioa = 0;
        JSlider obj = (JSlider) e.getSource();
        System.out.println(obj.getValueIsAdjusting());
        System.out.println(obj.getValue());
        if (!obj.getValueIsAdjusting()) {
            System.out.println(obj.getValue());
            balioa = (int) obj.getValue();

            if (obj == sliderDolar) {
                txtDolar.setText(String.valueOf(balioa));
                float iAldaketa = 100 * balioa / Float.parseFloat(txtAldaketa.getText());
                iAldaketa = Math.round(iAldaketa);
                iAldaketa = iAldaketa / 100;
                // aldatu txtEuro
                txtEuro.setText(String.valueOf(iAldaketa));
                // aldatu sliderEuro
                int i = Math.round(iAldaketa);
                sliderEuro.setValue(i);
            }

            if (obj == sliderEuro) {
                txtEuro.setText(String.valueOf(balioa));
                float iAldaketa = 100 * balioa * Float.parseFloat(txtAldaketa.getText());
                iAldaketa = Math.round(iAldaketa);
                iAldaketa = iAldaketa / 100;
                // aldatu txtDolar
                txtDolar.setText(String.valueOf(iAldaketa));
                // aldatu sliderDolar
                int i = Math.round(iAldaketa);
                // Emen Dolar jarri dugu euroan zegoen balioa eta horrke oztopatu egiten zuen
                // dolarra.
                sliderDolar.setValue(i);
            }
        }
    }

    public static void jarriElementuak() {
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        sliderEuro.setBorder(BorderFactory.createTitledBorder("Euroak"));
        sliderEuro.setMajorTickSpacing(200);
        sliderEuro.setMinorTickSpacing(100);
        sliderEuro.setPaintTicks(true);
        sliderEuro.setPaintLabels(true);
        sliderDolar.setBorder(BorderFactory.createTitledBorder("Dolarrak"));
        sliderDolar.setMajorTickSpacing(200);
        sliderDolar.setMinorTickSpacing(100);
        sliderDolar.setPaintTicks(true);
        sliderDolar.setPaintLabels(true);

        // Hasierako metodoa ez zen funtzionala, eta vertsio aldaketa baten gatik
        // funtzinala hurrengoa da:
        sliderEuro.setEnabled(true);
        sliderDolar.setEnabled(true);

        panel1.add(lblEuroak);
        panel1.add(txtEuro);
        panel1.add(sliderEuro);
        panel2.add(label);
        panel2.add(txtAldaketa);
        panel3.add(lblDolarrak);
        panel3.add(txtDolar);
        panel3.add(sliderDolar);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Eredu batetik (JTextField) bestera (slider) fokua aldatzen denean,
        // horren erantzuna kudeatzeko erabiliko den ekintza.
        // ActionLsitener erabiltzen badugu, ez dugu erantzuna jasotzen.
        txtEuro.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                aldatuTextua(e);
            }
        });

        txtDolar.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                aldatuTextua(e);
            }
        });

        // Slider baten balioa aldatzean erabiliko den ekintza.
        sliderEuro.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                mugituSlider(e);
            }
        });

        sliderDolar.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                mugituSlider(e);
            }
        });

        frame.setLayout(new FlowLayout());
        panel1.setLayout(new GridLayout(0, 1));
        panel2.setLayout(new GridLayout(0, 1));
        panel3.setLayout(new GridLayout(0, 1));
        frame.pack();
        frame.setVisible(true);
    }
}
