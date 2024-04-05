package Pegas.lection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?>car = Car.class;
        Constructor<?>[] constructor = car.getConstructors();
        System.out.println(Arrays.toString(constructor));
        Object gaz = constructor[0].newInstance("BMW", "25", "123", "250", 123);
        System.out.println(gaz);
        Field[] fields = gaz.getClass().getDeclaredFields();
        fields[fields.length-1].setAccessible(true);
        int temp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, 555);
        System.out.println(gaz);
        Method[] methods = gaz.getClass().getMethods();
        System.out.println(Arrays.toString(methods));
    }
}
