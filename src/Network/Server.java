package Network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Utils.ConfigReader;

public class Server {
	ServerSocket serverS;
	InetAddress ip = InetAddress.getLocalHost();
	ArrayList<ServerWorker> workers = new ArrayList<>();

	public Server() throws IOException {
		int port = Integer.parseInt(ConfigReader.getValue("Port_No"));
		serverS = new ServerSocket(port);
		System.out.println("Server Start and waiting for clinets to join......");
		handleClientRquest();

	}

	public void handleClientRquest() throws IOException {
		while (true) {
			Socket clientsocket = serverS.accept(); // Hand Shaking
			// per client per thread
			ServerWorker serverworker = new ServerWorker(clientsocket, this); // creatin a new thread
			workers.add(serverworker);
			serverworker.start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Server obj = new Server();
	}

}
