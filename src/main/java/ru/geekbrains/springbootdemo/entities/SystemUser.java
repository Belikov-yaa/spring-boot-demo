package ru.geekbrains.springbootdemo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springbootdemo.validation.FieldMatch;
import ru.geekbrains.springbootdemo.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {
    @NotNull(message = "not null check")
    @Size(min = 3, message = "username length must be greater than 2 symbols")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 letters/digits")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @ValidEmail
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String email;

//    @NotNull
//    @Min(value = 0, message = "value must be greater or equals than 0")
//    @Max(value = 10, message = "value must be lesser or equals than 10")
//    private Integer count;
}
