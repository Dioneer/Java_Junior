package Pegas.seminar1.hw1;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Double rez = createOfArr(1,25,44,56,5,221,1).stream()
                .mapToInt(Integer::intValue)
                .filter(i-> i%2==0)
                .average().orElse(Double.NaN);
        System.out.println(rez);
    }
    public static List<Integer> createOfArr(Integer... ids){
        return Arrays.asList(ids);
    }
}
