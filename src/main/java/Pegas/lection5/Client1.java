package Pegas.lection5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8081);
            Scanner scanner = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){
            while(true){
                System.out.println("Enter your message for server: ");
                String outputMessage = scanner.nextLine();
                dos.writeUTF(outputMessage);
                dos.flush();
                System.out.println("Server answer: " + dis.readUTF());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Your chat is finish");
        }
    }
}
