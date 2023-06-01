package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread {
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket , Server server) throws IOException
	{
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();
		out = clientSocket.getOutputStream();
		this.server = server;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Read data from client and braoadcast the data to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true)
		{
			
				line = br.readLine();
				if(line.equalsIgnoreCase("quit")){
				break;
			} 
				//out.write(line.getBytes());
				//BroadCast to all
				for(ServerWorker serverWorker : server.workers)
				{	
					line = line+"\n";
					serverWorker.out.write(line.getBytes());
				}
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(clientSocket!=null)
				try {
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	

}
