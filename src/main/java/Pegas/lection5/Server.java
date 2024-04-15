package Pegas.lection5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8081)){
            while(true){
                Runnable runnable = () -> {
                    try(Socket socket = serverSocket.accept();
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        Scanner scanner = new Scanner(System.in)){
                        String st = dis.readUTF();
                        while (!st.equals("close")) {
                            System.out.println("Get your message: " + st);
                            System.out.println("Enter you answer: ");
                            String answer = scanner.nextLine();
                            dos.writeUTF(answer);
                            dos.flush();
                            st=dis.readUTF();
                        }
                    }catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
                Thread tr = new Thread(runnable);
                tr.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
