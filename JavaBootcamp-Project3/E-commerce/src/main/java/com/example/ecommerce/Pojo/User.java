package com.example.ecommerce.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "id Should not be empty")
    @Size(min = 3, message = "ID must be 3 char atleast")
    private String id;
    @NotEmpty(message = "username must not be empty")
    @Size(min = 5, message ="username must be 5 at least" )
    private String username;
    @NotEmpty(message = "password must not be empty")
    @Size(min = 6, message = "password must be 6 long")
    private String password;
    @NotEmpty(message = "email must not be empty")
    @Email(message = "must be valid email")
    private String email;
    @NotEmpty(message = "role must not be empty")
    @Pattern(regexp = "(?:^|\\W)Admin(?:$|\\W)|(?:^|\\W)Customer(?:$|\\W)", message = "Role must be Admin or Customer")
    private String role;
    @NotNull(message = "balance must not be empty")
    @Positive(message = "Must be positive")
    private int balance;

}
