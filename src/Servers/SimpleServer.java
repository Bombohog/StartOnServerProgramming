/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 01-09-2021
 *
 * Description of program
 ********************************************/

package Servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {

        try {

            int port = 8000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Accepting connection");
            Socket socket = serverSocket.accept();
            System.out.println("Established Connection");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String textFromClient;
            do {
                textFromClient = inputStream.readUTF();
                System.out.println("Text received from client: " + textFromClient);
                outputStream.writeUTF("Thanks fo the text.");
                outputStream.flush();
            } while (!textFromClient.equals("Disconnect"));

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
