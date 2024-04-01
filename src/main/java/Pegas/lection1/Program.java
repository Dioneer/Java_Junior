package Pegas.lection1;

import java.util.ArrayList;
import java.util.List;

public class Program{
    private static final Plain plain = (int x, int y)->x+y;
    private static final Plain plain1 = Integer::compare;
    private static final Plain plain2 = Integer::sum;

    public static void main(String[] args) {
        System.out.println(plain.action(3,22));
        System.out.println(plain1.action(22,22));
        System.out.println(plain2.action(22,22));

        List<String> list = new ArrayList<>();
    }
}

