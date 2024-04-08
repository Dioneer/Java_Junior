package Pegas.Seminar3.hw;

import java.io.IOException;

import static Pegas.Seminar3.hw.Utils.*;

public class Program {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student student = new Student("Masha", 28, 5.0);
        Utils.serializeToFile(FILE_JSON, student);
        Utils.serializeToFile(FILE_BIN, student);
        Utils.serializeToFile(FILE_XML, student);
        Utils.deserializeFromFile(FILE_XML);
        Utils.deserializeFromFile(FILE_BIN);
        Utils.deserializeFromFile(FILE_XML);
    }
}
