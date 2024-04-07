package Pegas.seminar2.hw2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    static Integer count = 0;
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Animal[] animals = {
                new Cat("Vasya", 5, "black"),
                new Cat("Busya", 8, "white"),
                new Cat("Kis", 15, "green"),
                new Dog("Bobick", 2, "big"),
                new Dog("Tosha", 8, "small"),
                new Dog("Drugshok", 12, "middle")
        };
        for (Animal a: animals){
            Class parentClass = a.getClass().getSuperclass();
            Field[] parentFields = parentClass.getDeclaredFields();
            Field[] childField = a.getClass().getDeclaredFields();

            for(Field f: childField){
                f.setAccessible(true);
            }

            for(Field pf: parentFields){
                pf.setAccessible(true);
            }
            System.out.println(a.getClass().getSimpleName()+count++);

            Arrays.stream(parentFields).forEach(i-> {
                try {
                    System.out.println("Field name of parent class: @"+i.getName()+"@ " +
                            "value: "+i.get(a));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

            Arrays.stream(childField).forEach(i-> {
                try {
                    System.out.println("Field name of child class: @"+i.getName()+"@ " +
                            "value: "+i.get(a));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

            Method[] methods = a.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(a);
                }

            }
        }
    }
}
