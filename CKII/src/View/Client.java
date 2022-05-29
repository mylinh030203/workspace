package View;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Client extends JFrame{
	JFrame client = new JFrame("Client");
	JButton BT[][] = new JButton[100][100];
	
	int n = 3;
	public Client() {
		
		Container cont = client.getContentPane();
		cont.setLayout(new GridLayout(n, n));
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				BT[i][j] = new JButton();
				cont.add(BT[i][j]);
			}
		}
		client.setSize(300,300);
		client.setVisible(true);
		client.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
