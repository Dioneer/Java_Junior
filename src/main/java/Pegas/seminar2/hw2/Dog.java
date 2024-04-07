package Pegas.seminar2.hw2;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Dog extends Animal{
    private final String size;

    public Dog(String name, int age, String size) {
        super(name, age);
        this.size = size;
    }

    public void makeRun(){
        System.out.println("This "+this.getClass().getSimpleName()+", name "+ this.getName() + " runs very fast");
    }
}
