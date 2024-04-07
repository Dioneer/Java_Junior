package Pegas.seminar2.hw2;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Cat extends Animal{
    private final String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void makeSound(){
        System.out.println("This "+this.getClass().getSimpleName()+", name "+ this.getName() + " makes sound");
    }
}
