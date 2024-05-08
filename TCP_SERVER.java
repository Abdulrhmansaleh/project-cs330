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
            
        }catch(Exception exception){
                System.out.println("Server is down, please try later.");
        }


    } 


}
