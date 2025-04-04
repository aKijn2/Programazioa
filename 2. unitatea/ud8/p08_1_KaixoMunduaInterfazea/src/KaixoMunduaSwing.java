import javax.swing.*;

public class KaixoMunduaSwing {
	public static void main(String[] args) {

		// Lehio baat sortzen dugu kaixo mundua leihoa tituloarekin
		JFrame frame = new JFrame("Kaixo mundua leihoa");

		// Defektuz x botoiari ematerakoa programa amaitzea
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Kaixo mundua testua erakusten duen lable bat
		JLabel label = new JLabel("Kaixo mundua");

		// Leihoan label-a kokatzen dugu eta bisiblea jartze dugu
		frame.getContentPane().add(label);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
