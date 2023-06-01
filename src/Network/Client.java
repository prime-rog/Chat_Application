package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import Utils.ConfigReader;

public class Client {
	Socket socket ;
	OutputStream out ; 
	InputStream in;
	ClientWorker wroker;
	JTextArea textArea;
	InetAddress ip = InetAddress.getLocalHost();
	public Client(JTextArea textArea) throws UnknownHostException, IOException
	{
		int port = Integer.parseInt(ConfigReader.getValue("Port_No"));
		socket = new Socket(ip, port);
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessages();

	}
	
	public void sendMessage(String message) throws IOException
	{
		message = message+"\n";
		System.out.println("message recived" + message);
		out.write(message.getBytes());
	}
	public void readMessages()
	{
		wroker = new ClientWorker(in , textArea );
		wroker.start();
	}

}
