package Pegas.seminar1.task1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;

}
