import java.io.*;
import java.net.*;
import java.util.*;
public class TCP_SERVER {
    public static void main(String[] args) throws Exception
    {
        // this variable for listening to the client that creates a socket
        
        try
        {
            ServerSocket listener = new ServerSocket(1014);            
            Socket response =  listener.accept(); //the listener socket waits until the client establish a tcp connection
            //to send and recieve data from client to a server and vice versa
            DataInputStream recive = new DataInputStream(response.getInputStream());
            DataOutputStream send = new DataOutputStream(response.getOutputStream());
            
            send.writeUTF(Integer.toBinaryString(recive.readInt()));
            response.close();
        }catch(Exception exception){
            System.out.println("Server is down, please try later.");
        }
    
        
    } 


}
