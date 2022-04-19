package echoserverclient;
import java.net.*; 
import java.io.*; 
import java.util.Scanner;

public class DateClient {
	private final static String HOSTNAME = "localhost";
	
	public static void main(String[] args) {
		try (Socket sock = new Socket("127.0.0.1",6013);
	             InputStreamReader isr = new InputStreamReader(sock.getInputStream());
	             BufferedReader in = new BufferedReader(isr);
	             PrintWriter out = new PrintWriter(sock.getOutputStream(), true)
	        ) {
	            System.out.println("Connected to " + HOSTNAME + " on " + sock);
	            
	            Scanner myObj = new Scanner(System.in);
    			//System.out.println("Enter a Message: ");
    			String message = "";
    			
    			do {
    				System.out.println("Enter a Message: ");
    				message = myObj.nextLine();
        			
        			
    	            System.out.println("\nSending to server:\n" + "'" + message + "'");
    	            out.println(message);
    	            
    	            String line;
    	            line = in.readLine();
    	            System.out.println("Client received:\n" + "'" + line + "'");
    	            System.out.println("-----------------\n");
    	            
    			}
    			while(!message.equals("Bye"));
    			myObj.close();
    			System.out.println("\nServer is now Closed.");
	        }
		catch (IOException ioe) {
			System.err.println(ioe); 
		}

	}

}

