package Pegas.Lection3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String str = "Hello!";
//        SerialObj(str);
//        DeSerialObj(str);
        SerialObj(new Cat("Gosha", "Deer", 5));
        DeSerialObj();
    }
    public static void SerialObj(Object str)throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("try.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(str);
        oos.close();
    }
    public static void DeSerialObj() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("try.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cat s = (Cat) ois.readObject();
        ois.close();
        System.out.println(s);
    }

}
