import java.io.*;
import java.net.*;
import java.util.*;
public class TCP_CLIENT {
    public static void main(String[]args) throws Exception{
        
        
        //client socket for sending data to a server
        Socket client_Socket = new Socket("Vipin-PC",1014);
        
        //to send and recieve data from client to a server and vice versa
        DataInputStream recive = new DataInputStream(client_Socket.getInputStream());
        DataOutputStream send = new DataOutputStream(client_Socket.getOutputStream());

        //To get inputs from client
        Scanner inputs = new Scanner(System.in);
        
        System.out.println("choose option\nB: to convert to binary\nH: to convert to hexadecimal\nQ: to quit the client program\n");

        char option = inputs.next().charAt(0); //this variable for storing the answer of user option

        if (option == 'Q') //if the option is quite then exit terminate the connection
        {
           client_Socket.close();
           System.exit(0); 
        }        

        System.out.println("\nEnter A Number\n");

        int number = inputs.nextInt(); //to get the user input
        
        send.writeChar(option);
        send.writeInt(number);

        System.out.println("the number is: "+recive.readUTF());
        
        send.close();recive.close();client_Socket.close();       
        
    
    }
}
