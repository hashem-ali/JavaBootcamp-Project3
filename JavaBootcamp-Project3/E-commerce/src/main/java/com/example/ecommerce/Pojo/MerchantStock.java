package com.example.ecommerce.Pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "id Should not be empty")
    @Size(min = 3, message = "ID must be 3 char atleast")
    private String id;
    @NotEmpty(message = "product id Should not be empty")
    @Size(min = 3, message = "product ID must be 3 char atleast")
    private String productid;
    @NotEmpty(message = "merchantid id Should not be empty")
    @Size(min = 3, message = "merchantid ID must be 3 char atleast")
    private String merchantid;
    @NotEmpty(message = "stock must not be empty")
    @Size(min = 10, message = "stcok must be 10 at start")
    private int stock;
}
