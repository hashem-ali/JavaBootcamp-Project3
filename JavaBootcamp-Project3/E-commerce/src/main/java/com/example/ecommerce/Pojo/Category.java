package com.example.ecommerce.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "id Should not be empty")
    @Size(min = 3, message = "ID must be 3 char atleast")
    private String id;
    @NotEmpty(message = "name Should not be empty")
    @Size(min = 3, message = "name must be atleast 3 chars ")
    private String name;
}
