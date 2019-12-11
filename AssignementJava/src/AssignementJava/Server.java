package AssignementJava;

import java.net.*;
import java.io.*;

public class Server 
{
    private static int portNumber = 5050;
        
    public static void main(String args[]) {
                
        boolean listening = true;
        ServerSocket serverSocket = null;
        
        try 
        {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("New Server has started listening on port: " + portNumber );
        } 
        catch (IOException e) 
        {
            System.out.println("Cannot listen on port: " + portNumber + ", Exception: " + e);
            System.exit(1);
        }
        

        while (listening) 
        {
            Socket clientSocket = null;
            try{
                System.out.println("**. Listening for a connection...");
                clientSocket = serverSocket.accept();
                System.out.println("00. <- Accepted socket connection from a client: ");
                System.out.println("    <- with address: " + clientSocket.getInetAddress().toString());
                System.out.println("    <- and port number: " + clientSocket.getPort());
            } 
            catch (IOException e){
                System.out.println("XX. Accept failed: " + portNumber + e);
                listening = false;
            }        
            
            ConnectionHandler con = new ConnectionHandler(clientSocket);
            con.init(); 
            System.out.println("02. -- Finished communicating with client:" 
                          + clientSocket.getInetAddress().toString());
        }
        
        try 
        {
            System.out.println("04. -- Closing down the server socket gracefully.");
            serverSocket.close();
        } 
        catch (IOException e) 
        {
            System.err.println("XX. Could not close server socket. " + e.getMessage());
        }
    }
}
