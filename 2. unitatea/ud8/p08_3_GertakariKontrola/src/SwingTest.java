import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTest {

	// Sortu dugu leio bat eta bi botoi.
	private static JLabel label = new JLabel("--");
	private static JButton btnGarbitu = new JButton("Garbitu");
	private static JButton btnIdatzi = new JButton("Idatzi");

	/**
	 * Botoi batean klik egiterakoan botoia garbituko du edo idatzi egingo du
	 * 
	 * @param e ActionEvent izena duen parametro bat
	 */
	public static void ekintzak(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnGarbitu) {
			label.setText("");
		}
		if (obj == btnIdatzi) {
			label.setText("Kaixo mundua");
		}
	}

	/**
	 * Main metodoa hasieratzen da
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}

		/**
		 * Frame bat sortzen dugu eta titulo bat ezartzen diogu.
		 */
		JFrame frame = new JFrame("Gertakaria kontrolatzen");

		/**
		 * Aktio listener bat gehitu dugu btnGarbitu dana non klikatzerakoan
		 * ekintzak ebentua hasieratuko du.
		 */
		btnGarbitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ekintzak(e);
			}
		});

		/**
		 * Aktio listener bat gehitu dugu btnIdatzi dana non klikatzerakoan
		 * ekintzak ebentua hasieratuko du.
		 */
		btnIdatzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ekintzak(e);
			}
		});

		/**
		 * Frameak gehitu egite ditugu
		 */
		frame.getContentPane().add(label);
		frame.getContentPane().add(btnGarbitu);
		frame.getContentPane().add(btnIdatzi);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/**
		 * Frameak konfiguratu egiten ditugu.
		 */
		frame.setLayout(new GridLayout(0, 1));
		frame.pack();
		frame.setVisible(true);

		// Frame-aren tamaina handitu dut tituloa ikusteko
		frame.setSize(400, 300);
	}
}
