package Pegas.seminar4.models;

import java.util.Random;

public final class StudentsFactory {
    private static final Random random  = new Random();
    private static final String[] names = new String[]{"Tosha", "Gosha", "Marty", "Sasha", "Vlad","Klim", "Killy", "Filly"};

    public static Student create(){
        return new Student(names[random.nextInt(names.length)], random.nextInt(20,26));
    }
    private StudentsFactory(){}
}
