package Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost",3333);
	}
	public void Send(String data) throws IOException {
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF(data);
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client c = new Client();
		c.Send("Hello");
		c.Send("Hello");
		c.Send("Hello");
	}
}
