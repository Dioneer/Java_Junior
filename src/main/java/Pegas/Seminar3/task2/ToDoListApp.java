package Pegas.Seminar3.task2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    public static final String FILE_JSON = "tasks.json";
    public static final String FILE_BIN = "tasks.bin";
    public static final String FILE_XML = "tasks.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveTasksToFile(String fileName, List<ToDo> tasks) {
        try{
        if(fileName.endsWith(".json")){
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), tasks);
        } else if (fileName.endsWith(".bin")) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
                oos.writeObject(tasks);
            }
        }else if(fileName.endsWith(".xml")){
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
            xmlMapper.writeValue(new File(fileName), tasks);
        }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void displayTasks(List<ToDo> tasks){
        System.out.println("List of tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            ToDo task = tasks.get(i);
            String status = task.isDone() ? "[x]":"[]";
            System.out.println((i+1)+". "+status+" "+task.getTitle());
        }
    }
    public static List<ToDo> loadTasksFromFile(String str) throws IOException {
        List<ToDo> tasks = new ArrayList<>();
        File file = new File(str);
        if(file.exists()){
            if(str.endsWith(".json")){
                tasks = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ToDo.class));
            } else if (str.endsWith(".bin")) {
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str))) {
                    tasks =(List<ToDo>)ois.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else if(str.endsWith(".xml")){
                tasks = xmlMapper.readValue(str, xmlMapper.getTypeFactory().constructCollectionType(List.class, ToDo.class));
            }
        }
        return tasks;
    }

    public static void addNewTask(Scanner scanner, List<ToDo> tasks) {
        System.out.println("Enter name of the new task: ");
        String newTask = scanner.nextLine();
        tasks.add(new ToDo(newTask));
        saveTasksToFile(FILE_JSON, tasks);
        saveTasksToFile(FILE_BIN, tasks);
        saveTasksToFile(FILE_XML, tasks);
        System.out.println("New task was added");
    }

    public static void markTaskAsDone(Scanner scanner, List<ToDo> tasks) {
        System.out.println("Enter number of the completed task: ");
        int taskNumber = Integer.parseInt(scanner.nextLine())-1;
        try {
            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                tasks.get(taskNumber).setDone(true);
                saveTasksToFile(FILE_JSON, tasks);
                saveTasksToFile(FILE_BIN, tasks);
                saveTasksToFile(FILE_XML, tasks);
                System.out.println("New task was marked as completed");
            } else {
                System.out.println("Uncorrected number of the task");
            }
        }catch (NumberFormatException e){
            System.out.println("Uncorrected enter");
        }
    }
}
