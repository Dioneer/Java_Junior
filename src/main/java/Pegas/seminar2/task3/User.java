package Pegas.seminar2.task3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

    @NotNull(message = "Name must be defined")
    @MaxLength(message = "Name must be less than 200 symbol")
    private final String name;
    @MinLength(value = 6, message = "The pass must be more than 6 symbols")
    private final String password;
    @Range(min=18, max = 100, message = "Age must be between 18 and 100")
    private final int age;
}
