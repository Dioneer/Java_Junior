package Pegas.seminar4.models.utils;


import Pegas.seminar4.models.enity.Student;

import java.util.Random;

public final class StudentsFactory {
    private static final Random random  = new Random();
    private static final String[] names = new String[]{"Tosha", "Gosha", "Marty", "Sasha", "Vlad","Klim", "Killy", "Filly"};

    public static Student create(){
        return new Student(names[random.nextInt(names.length)], random.nextInt(20,26));
    }
    private StudentsFactory(){}

    public static void updateAge(Student student){student.setAge(random.nextInt(20, 40));}
    public static void updateName(Student student){student.setName(names[random.nextInt(names.length)]);}
}
