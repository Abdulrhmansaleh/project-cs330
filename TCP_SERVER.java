import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TCP_SERVER {

  private static int decimal = 0;

  private static String option;

  private static final int port = 1014;

  private static String message = "";

  private static ServerSocket listener;

  private static Socket response;

  private static DataInputStream receive;

  private static DataOutputStream send;

  public static void main(String[] args) {

    while (true) {

      try {
        listener = new ServerSocket(port); // this variable for listening to the client that creates a socket
        response = listener.accept(); // the listener socket waits until the client establish a tcp connection

        // to send and receive data from client to a server and vice versa
        receive = new DataInputStream(response.getInputStream());
        send = new DataOutputStream(response.getOutputStream());

      } catch (Exception exception) {

        ///// here is the server down message must goes to client class
      }
      try {

        option = receive.readUTF();

        // to ensure 100% that it's a number and not letter or empty
        try {
          decimal = Integer.parseInt(receive.readUTF());
        } catch (Exception e) {

          // if the option and the number missing display following message
          if (!option.equalsIgnoreCase("B") && !option.equalsIgnoreCase("H") && !option.equalsIgnoreCase("H")) {
            message = "500\tRequest is empty";
            send.writeUTF(message);
            response.close();
            listener.close();
          } else {

            message = "400\tThe number is missing";
            send.writeUTF(message);
            response.close();
            listener.close();
          }
        }

        // if the missing value was the option
        if (!option.equalsIgnoreCase("B") && !option.equalsIgnoreCase("H") && !option.equalsIgnoreCase("Q")) {
          message = "300\tBad request";
          send.writeUTF(message);
          response.close();
          listener.close();
        } else if (option.equalsIgnoreCase("B")) {
          message = "200ok\t";
          send.writeUTF(message);
          send.writeUTF(Integer.toBinaryString(decimal));
        } else if (option.equalsIgnoreCase("H")) {
          message = "200ok\t";
          send.writeUTF(message);
          send.writeUTF(Integer.toHexString(decimal).toUpperCase());
        }
        // here to close TCP connection in case of quit option
        else {
          response.close();
          listener.close();
        }

        response.close();
        listener.close(); // close tcp connection
      } catch (Exception e) {
        ///////////////////////////////// Empty
      }

    }

  }

}
