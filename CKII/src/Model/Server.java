package Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;



public class Server {
	
	public Server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(3333);
		AcceptThread acceptThread = new AcceptThread(serverSocket);
		acceptThread.start();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Server();
	}

}
class AcceptThread extends Thread{
	ServerSocket serverSocket;
	public AcceptThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public void run() {
		while(true) {
			try {
				Socket socket = this.serverSocket.accept();
				WorkThread workThread = new WorkThread(socket);
				workThread.start();
				System.out.println(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
class WorkThread extends Thread{
	Socket socket;
	public WorkThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
			while(true) {
				String st = dataInputStream.readUTF();
				System.out.println(st);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


