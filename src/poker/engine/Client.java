package poker.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	//---------------------------------------------
		public static void main(String[] args) throws Exception{
			Client CLIENT = new Client();
			CLIENT.run();
		}	
	//------------------------------------------------
		

		private void run() throws Exception {
			Socket SOCK = new Socket("localhost", 444);
			PrintStream PS = new PrintStream(SOCK.getOutputStream());
			PS.println("Hello Server, a message from client");
			
			InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
			BufferedReader BR = new BufferedReader(IR);
			
			String incomingMessage = BR.readLine();
			System.out.println(incomingMessage);
		
		}
		
}
