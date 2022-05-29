package GUI;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client extends JFrame {
	JFrame sever = new JFrame("Client");
	JTextArea jTextArea = new JTextArea();
	
	JTextArea jTextField = new JTextArea(2,30);
	JButton button = new JButton("send");
	JScrollPane sp = new JScrollPane(jTextArea);
	JScrollPane sptf = new JScrollPane(jTextField);
	static String id ;
	static String name;
	
	public client() throws UnknownHostException, IOException {
		Scanner scanner = new Scanner(System.in);
		sp.setPreferredSize(new Dimension(250, 250));
		sptf.setPreferredSize(new Dimension(200,50));
		JPanel pn1 = new JPanel();
		pn1.add(sp);
		JPanel pn2 = new JPanel();
		pn2.add(sptf);
		JPanel pn3 = new JPanel();
		pn3.add(button);
		Container cont = sever.getContentPane();
		sever.setLocation(700, 10);
		cont.add(pn1,BorderLayout.NORTH);
		cont.add(pn2, BorderLayout.CENTER);
		cont.add(pn3, BorderLayout.EAST);
		sever.setSize(300,350);
		sever.setVisible(true);
		System.out.println("mời nhập vào id máy chủ");
		id = scanner.nextLine();
		System.out.print("Mời nhập vào tên của khách ");
		name = scanner.nextLine();
		Socket socket = new Socket(id, 3333);
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					dataOutputStream.writeUTF(name + ":"+ jTextField.getText());
					String text = "";
					jTextField.setText(text);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ClientThead clientThead = new ClientThead(socket, jTextArea);
		clientThead.start();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		client client = new client();
		
	}

}
class ClientThead extends Thread {
	Socket socket;
	JTextArea area;
	public ClientThead(Socket socket, JTextArea area) {
		this.socket = socket;
		this.area = area;
	}
	public void run() {
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			while (true) {
				String data = dataInputStream.readUTF();
				area.setText(area.getText() + "\n" + data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
