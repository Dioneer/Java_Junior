package Pegas.seminar2.hw2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Animal {
    private final String name;
    private final int age;
}
