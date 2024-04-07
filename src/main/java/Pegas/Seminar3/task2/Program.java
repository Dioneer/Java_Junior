package Pegas.Seminar3.task2;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Pegas.Seminar3.task2.ToDoListApp.*;

public class Program {
    public static void main(String[] args) throws IOException {
        List<ToDo>tasks;
        File f = new File(FILE_JSON);
        if(f.exists()&&!f.isDirectory()){
            tasks = loadTasksFromFile(FILE_JSON);
        }else{
            tasks = prepareTasks();
            saveTasksToFile(FILE_JSON, tasks);
            saveTasksToFile(FILE_BIN, tasks);
            saveTasksToFile(FILE_XML, tasks);
        }
        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose your point: ");
            System.out.println("1. Add new task");
            System.out.println("2. Mark your task as done");
            System.out.println("3. Out");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    ToDoListApp.addNewTask(scanner, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone(scanner, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTasksToFile(FILE_XML, tasks);
                    System.out.println("List is save");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Uncorrected choice, please, try again");
            }
        }
    }

    public static List<ToDo> prepareTasks(){
        List<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Go to the shop"));
        list.add(new ToDo("Walk with dog"));
        list.add(new ToDo("Change the lamp"));
        return list;
    }
}
