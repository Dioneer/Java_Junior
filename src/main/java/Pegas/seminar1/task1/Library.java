package Pegas.seminar1.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Crime and punishment", "Fyodor Dostoevsky", 1866));
        list.add(new Book("Eugene Onegin", "Alexander Pushkin", 1833));
        list.add(new Book("Война и мир", "Leo Tolstoy", 1869));
        list.add(new Book("The Master and Margarita", "Mikhail Bulgakov", 1967));
        list.add(new Book("Anna Karenina", "Leo Tolstoy", 1877));
        list.add(new Book("Anna Karenina", "Leo Tolstoy", 1877));

        List<Book> list2 = list.stream().filter(i->i.getAuthor().equals("Leo Tolstoy")).toList();
        System.out.println(list2);
        List<Book> list3 = list.stream().filter(i->i.getYear()>1866).toList();
        System.out.println(list3);
        List<String> list4 = list.stream().map(Book::getTitle).distinct().toList();
        System.out.println(list4);

    }
}
