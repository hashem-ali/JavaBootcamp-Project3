package com.example.ecommerce.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPojo {
    @NotEmpty(message = "id Should not be empty")
    @Size(min = 3, message = "ID must be 3 char atleast")
    private String id;
    @NotEmpty(message = "name Should not be empty")
    @Size(min = 3, message = "name must be atleast 3 chars ")
    private String name;
    @NotNull(message = "price should not be empty")
    @Positive(message = "price must be positive")
    private int price;
    @NotEmpty(message = "category Id must not be empty")
    @Size(min = 3, message = "Category Id must be 3 chars at least")
    private String categoryID;

}
