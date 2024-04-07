package Pegas.Lection3;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cat implements Serializable {
    private final String name;
    private final String patronus;
    private final int age;
}
