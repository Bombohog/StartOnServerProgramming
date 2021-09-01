/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 01-09-2021
 *
 * Description of program
 ********************************************/

package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 8000);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            String textFromScanner;
            do {
                textFromScanner = scanner.nextLine();
                outputStream.writeUTF(textFromScanner);
                outputStream.flush();
                System.out.println(inputStream.readUTF());
            } while (!textFromScanner.equals("Disconnect"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
