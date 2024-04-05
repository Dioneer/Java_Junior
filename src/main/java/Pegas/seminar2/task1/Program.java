package Pegas.seminar2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> person = Person.class;
//        Class<?> person1 = Class.forName("Pegas.seminar2.task1.Person");
        Person person2 = new Person("iiii", 25);
//        ClassLoader cls = person2.getClass().getClassLoader();
//        System.out.println(cls.getClass().getSimpleName());

        System.out.println();
        Field[] fields = person2.getClass().getDeclaredFields();
        for(Field f: fields){
            System.out.println("Field: " + f.getName());
        }
        Constructor[] constructors = person.getConstructors();
        System.out.println(Arrays.toString(constructors));
        Person person5 = (Person) constructors[0].newInstance(null, 0);
        Field nameField = person5.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person5, "Gosha");
        System.out.println(person5);

        Method displayInfoMethod = person.getDeclaredMethod("show");
        displayInfoMethod.invoke(person5);
    }
}
