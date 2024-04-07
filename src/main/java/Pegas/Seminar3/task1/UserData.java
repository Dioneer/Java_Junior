package Pegas.Seminar3.task1;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserData implements Serializable {
    private final String name;
    private final int age;
    transient final String password;
}
