package Pegas.lection1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program{
    private static final Plain plain = (int x, int y)->x+y;
    private static final Plain plain1 = Integer::compare;
    private static final Plain plain2 = Integer::sum;

    public static void main(String[] args) {
        System.out.println(plain.action(3,22));
        System.out.println(plain1.action(22,22));
        System.out.println(plain2.action(22,22));

        List<String> list = Arrays.asList("Hi", "Ho", "He","Hrhrhr");
        List<String> list1= list.stream().map(String::toCharArray).filter(i->i[1]!='e').map(String::valueOf).toList();
        System.out.println(list1);

        Stream.of(1,10,5,8,9,1).sorted().forEach(System.out::println);
    }
}

