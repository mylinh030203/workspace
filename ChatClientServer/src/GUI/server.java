package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class server extends JFrame {
	JFrame sever = new JFrame("Server");
	JTextArea jTextArea = new JTextArea();
	
	JTextArea jTextField = new JTextArea(2,30);
	JButton button = new JButton("send");
	JScrollPane sp = new JScrollPane(jTextArea);
	JScrollPane sptf = new JScrollPane(jTextField);
	public server() throws IOException {
		
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
		
		cont.add(pn1,BorderLayout.NORTH);
		cont.add(pn2, BorderLayout.CENTER);
		cont.add(pn3, BorderLayout.EAST);
		sever.setSize(300, 350);
		sever.setVisible(true);
		
		AcceptThread ac = new AcceptThread(jTextArea);
		ac.start();
	
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DataOutputStream dataOutputStream = null;
					DataInputStream dataInputStream = null;
					for (Socket s : ac.getArrayListSocket()) {
						dataOutputStream = new DataOutputStream(s.getOutputStream());
						dataInputStream = new DataInputStream(s.getInputStream());
						dataOutputStream.writeUTF("Server : "+jTextField.getText());
					}
					jTextField.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	class AcceptThread extends Thread{
		ArrayList<Socket> arrayListSocket = new ArrayList<Socket>();
		ArrayList<ServerThead> arrayListServerThead = new ArrayList<ServerThead>(); 
		JTextArea jTextArea;
		
		public AcceptThread(JTextArea jTextArea)  {
			this.jTextArea = jTextArea;
		}
		
		public ArrayList<Socket> getArrayListSocket() {
			return arrayListSocket;
		}
		
		public void setArrayListSocket(ArrayList<Socket> arrayListSocket) {
			this.arrayListSocket = arrayListSocket;
		}



		public void run(){

			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(3333);
				while (true) {
					Socket socket = serverSocket.accept();
					ServerThead serverThead = new ServerThead(jTextArea, socket);
					arrayListSocket.add(socket);
					arrayListServerThead.add(serverThead);
					jTextArea.setText(jTextArea.getText() + "\n" + socket+"");
					for (ServerThead s : arrayListServerThead)
						s.setArrayListSocket(arrayListSocket);
					serverThead.start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	class ServerThead extends Thread {
		ArrayList<Socket> arrayListSocket = new ArrayList<Socket>();
		JTextArea area;
		Socket socket;
		public ServerThead(JTextArea area, Socket socket) {
			this.area = area;
			this.socket = socket;
		}
		
		
		public ArrayList<Socket> getArrayListSocket() {
			return arrayListSocket;
		}


		public void setArrayListSocket(ArrayList<Socket> arrayListSocket) {
			this.arrayListSocket = arrayListSocket;
		}


		public void run() {
			try {
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				while (true) {
					String data = dataInputStream.readUTF();
					for (Socket s : arrayListSocket) {
						dataOutputStream = new DataOutputStream(s.getOutputStream());
						dataInputStream = new DataInputStream(s.getInputStream());
						dataOutputStream.writeUTF(data);
					}
					area.setText(area.getText() + "\n" + data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public static void main(String[] args) throws IOException {
		server server = new server();
		
	}

}
