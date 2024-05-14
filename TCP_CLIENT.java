import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a TCP client that connects to a server and sends
 * requests to convert numbers.
 */
public class TCP_CLIENT {
  private static final int port = 1014;
  private static String message = "";

  /**
   * The main method of the TCP_CLIENT class.
   * It establishes a connection with the server, sends requests, and receives
   * responses.
   */
  public static void main(String[] args) {

    try {
      // client socket for sending data to a server
      Socket client_Socket = new Socket("127.0.0.1", port);

      // to send and receive data from client to a server and vice versa
      DataInputStream receive = new DataInputStream(client_Socket.getInputStream());
      DataOutputStream send = new DataOutputStream(client_Socket.getOutputStream());

      // To get inputs from a client
      Scanner inputs = new Scanner(System.in);

      System.out.println(
          "choose option\nB: to convert to binary\nH: to convert to hexadecimal\nQ: to quit the client program\n");

      String option = inputs.nextLine();// this variable for storing the answer of user option

      // check user option
      if (!option.equalsIgnoreCase("H") && !option.equalsIgnoreCase("B") && !option.equalsIgnoreCase("Q")) {
        System.out.println("300\tBad request");
        System.exit(1);
      }
      // possibility for an error to occur
      if (genrate_error() < 17) {
        option = (char) new Random().nextInt() + ""; // genrate random option
      }

      send.writeUTF(option); // send the option to TCP_SERVER
      if (option.equalsIgnoreCase("Q")) {
        send.close();
        receive.close();
        client_Socket.close();
        System.exit(0);
      }

      System.out.print("\nEnter A Number: ");

      String number = inputs.nextLine(); // to get the decimal input

      // if the input is not number an exception will occur
      Integer.parseInt(number);
      inputs.close();

      // possibility for an error to occur
      if (genrate_error() < 17) {
        number = (char) new Random().nextInt() + ""; // genrate random number
      }
      send.writeUTF(number); // send the number to TCP_SERVER

      // display error messages received from TCP_SERVER
      message = receive.readUTF();
      if (!message.equals("200ok\t")) {
        System.out.println(message);
        send.close();
        receive.close();
        client_Socket.close();
        System.exit(1);
      }

      System.out.print(message);
      System.out.println(receive.readUTF()); // receive the converted number from TCP_SERVER
      send.close();
      receive.close();
      client_Socket.close();

    } catch (NumberFormatException e) { // if the input was not number catch the error
      System.out.println("400\tThe number is missing");
      System.exit(1);

    } catch (Exception e) {
      System.err.println("Server is down, please try again later.");
      System.exit(0);
    }
  }

  // genrate_error(); generate number between 0-99
  private static int genrate_error() {
    return new Random().nextInt(100);
  }

}
