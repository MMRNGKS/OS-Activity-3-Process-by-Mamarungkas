package echoserverclient;
import java.net.*; 
import java.io.*; 

public class DateServer {

	public static void main(String[] args) {
		try { 
			ServerSocket sock = new ServerSocket(6013);
			
			System.out.println("Listening on " + sock);
			
			while (true) { 
				
				
				try (Socket client = sock.accept();
		                 InputStreamReader isr = new InputStreamReader(client.getInputStream());
		                 BufferedReader in = new BufferedReader(isr);
		                 PrintWriter out = new PrintWriter(client.getOutputStream(), true))
				{
					System.out.println("Connection accepted");
					 
	                String line;
	                while ((line = in.readLine()) != null) {
	                    System.out.println("\nServer received: " + "'" + line + "'");
	                    System.out.println("Server Echoes " + "'" + line + "'" + " to the client.");
	                    out.println(line);
	 
	                    if (line.equals("Bye")) {
	                    	System.out.println("\nServer is Closed.");
	                    	sock.close();
	                        break;
	                    }
	                }
				}

			} 
			
			}
			catch (IOException ioe) { 
				System.err.println(ioe); 
			}
	}

}


