package Pegas.Seminar3.hw;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable{
    private String name;
    private int age;
    private transient double GPA;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
}
