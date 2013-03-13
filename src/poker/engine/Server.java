package poker.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	//---------------------------------------------
		public static void main(String[] args) throws Exception{
			Server SERVER = new Server();
			SERVER.run();
		}	
	//------------------------------------------------
		

		private void run() throws Exception {
			ServerSocket SRVSOCK = new ServerSocket(444);
			Socket SOCK = SRVSOCK.accept();
			InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
			BufferedReader BR = new BufferedReader(IR);
			
			String incomingMessage = BR.readLine();
			System.out.println(incomingMessage);
			
			if (incomingMessage != null){
				PrintStream PS = new PrintStream(SOCK.getOutputStream());
				PS.println("Server Received Message");
			}
			
		}
		
		
		
}
