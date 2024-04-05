package Pegas.seminar2.task1;

import lombok.Value;

@Value
public class Person {
    String name;
    int age;

    public void show(){
        System.out.println("start");
    }
}
