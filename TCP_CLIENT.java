import java.io.*;
import java.net.*;
import java.util.*;
public class TCP_CLIENT {
    private static final int port = 1014;
    private static String message = "";
    
    public static void main(String[]args) throws Exception{
        
        
        //client socket for sending data to a server
        Socket client_Socket = new Socket("127.0.0.1",port);
        
        //to send and recieve data from client to a server and vice versa
        DataInputStream receive = new DataInputStream(client_Socket.getInputStream());
        DataOutputStream send = new DataOutputStream(client_Socket.getOutputStream());

        //To get inputs from a client
        Scanner inputs = new Scanner(System.in);
        
        System.out.println("choose option\nB: to convert to binary\nH: to convert to hexadecimal\nQ: to quit the client program\n");
  

        String option = inputs.nextLine();//this variable for storing the answer of user option
        
        send.writeUTF(option); //send the option to TCP_SERVER
        if (option.equalsIgnoreCase("Q")) {
          send.close();receive.close();client_Socket.close(); 
          System.exit(0);
          
        }
        
        System.out.print("\nEnter A Number: ");
        
        String number = inputs.nextLine(); //to get the decimal input
        inputs.close();
        
        send.writeUTF(number);  //send the number to TCP_SERVER
        
        //display error messages received from TCP_SERVER
        message = receive.readUTF();
        if(!message.equals("200\tOk and the number is based on the request(B/H)"))
        {
          System.out.println(message);
          send.close();receive.close();client_Socket.close(); 
          System.exit(1);
        
        }
        
      
       
      
        System.out.println("the number is: "+receive.readUTF()); //receive the converted number from TCP_SERVER
        System.out.println(message + '\n');
        send.close();receive.close();client_Socket.close();       
        
    
    }
}
