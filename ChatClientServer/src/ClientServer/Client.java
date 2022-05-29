package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("10.50.67.140", 3333);
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap du lieu: ");
			String data = scanner.nextLine();
			dataOutputStream.writeUTF(data);
//			
//			data= dataInputStream.readUTF();
//			System.out.println("sever: "+data);
		}
	}

}
