package Pegas.Seminar3.hw;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.lang.reflect.Field;

public final class Utils {
    public static final String FILE_JSON = "hw3.json";
    public static final String FILE_BIN = "hw3.bin";
    public static final String FILE_XML = "hw3.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    private Utils(){}

    public static void serializeToFile(String fileName, Student student) throws IOException {
        if(fileName.endsWith(".json")){
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), student);
        } else if(fileName.endsWith(".bin")){
            if(fileName.endsWith(".bin")){
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
                    oos.writeObject(student);
                }
            }
        } else if (fileName.endsWith(".xml")) {
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(fileName), student);
        }else{
            System.out.println("Wrong type of the file");
        }
    }
    public static void deserializeFromFile(String fileName) throws IOException, IllegalAccessException {
        if(fileName.endsWith(".json")){
            Student student1 = objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructType(Student.class));
            showFields(student1);
        } else if(fileName.endsWith(".bin")){
            if(fileName.endsWith(".bin")){
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
                    Student student1 = (Student) ois.readObject();
                    showFields(student1);
                } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (fileName.endsWith(".xml")) {
            Student student1 = xmlMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructType(Student.class));
            showFields(student1);
        }else{
            System.out.println("Wrong type of the file");
        }
    }
    private static void showFields(Student student) throws IllegalAccessException {
        Field[] fields = student.getClass().getDeclaredFields();
        for (Field f: fields){
            f.setAccessible(true);
            System.out.println(f.getName()+": "+f.get(student));
        }
    }
}
