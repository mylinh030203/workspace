package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(3333);
		
		Socket socket = serverSocket.accept();
		System.out.println(socket);
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String data = dataInputStream.readUTF();
			System.out.println("Client: " + data);
//			System.out.println("@@@@: ");
//			data = scanner.nextLine();
//			dataOutputStream.writeUTF(data);
		}
		
	}
}
