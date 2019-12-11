package ProjectJava;

import java.net.*;
import java.io.*;

public class ThreadedConnectionHandler extends Thread
{
    private Socket clientSocket = null;				
    private ObjectInputStream is = null;			
    private ObjectOutputStream os = null;			
    private DateTimeService theDateService;
    
	
    public ThreadedConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
  
        theDateService = new DateTimeService();
    }

   
    public void run() {
         try {
            this.is = new ObjectInputStream(clientSocket.getInputStream());
            this.os = new ObjectOutputStream(clientSocket.getOutputStream());
            while (this.readCommand()) {}
         } 
         catch (IOException e) 
         {
        	System.out.println("XX. There was a problem with the Input/Output Communication:");
            e.printStackTrace();
         }
    }


    private boolean readCommand() {
        String s = null;
        try {
            s = (String) is.readObject();
        } 
        catch (Exception e){    
        	this.closeSocket();
            return false;
        }
        System.out.println("01. <- Received a String object from the client (" + s + ").");
        
        if (s.equalsIgnoreCase("GetDate")){ 
            this.getDate(); 
        }       
        else { 
            this.sendError("Invalid command: " + s); 
        }
        return true;
    }


    private void getDate() {	
        String[] currentDateTimeText = theDateService.getDateAndTime();
        this.send(currentDateTimeText);
    }

   
    private void send(Object o) {
        try {
            System.out.println("02. -> Sending (" + o +") to the client.");
            this.os.writeObject(o);
            this.os.flush();
        } 
        catch (Exception e) {
            System.out.println("XX." + e.getStackTrace());
        }
    }
    
 
    public void sendError(String message) { 
        this.send("Error:" + message);	
    }
    
 
    public void closeSocket() { 
        try {
            this.os.close();
            this.is.close();
            this.clientSocket.close();
        } 
        catch (Exception e) {
            System.out.println("XX. " + e.getStackTrace());
        }
    }
}