package Pegas.Seminar3.task1;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        UserData user = new UserData("Elena", 30, "123456");
        System.out.println("Name: "+user.getName());
        System.out.println("Age: "+user.getAge());
        System.out.println("Pass: "+user.getPassword());
        System.out.println();

        try(FileOutputStream fos = new FileOutputStream("userdata.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(user);
            System.out.println("Object UserData is serializable");
        }
        try(FileInputStream fis = new FileInputStream("userdata.bin");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            UserData ud = (UserData) ois.readObject();
            System.out.println(ud);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
