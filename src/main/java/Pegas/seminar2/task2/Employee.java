package Pegas.seminar2.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "employees")
public class Employee {

    @Column(name = "id", primaryKey = true)
    private final UUID id;
    @Column(name = "username")
    private final String username;
    @Column(name = "email")
    private final String email;
}
