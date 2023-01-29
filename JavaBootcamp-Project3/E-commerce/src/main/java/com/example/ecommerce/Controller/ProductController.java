package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.ProductPojo;
import com.example.ecommerce.Pojo.User;
import com.example.ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product/")
@RequiredArgsConstructor
public class ProductController {
    public final ProductService productService;

    @GetMapping("get")
    public ResponseEntity getProducts(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @PostMapping("add")
    public ResponseEntity addProduct(@Valid @RequestBody ProductPojo product, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@Valid @PathVariable String id, @Valid @RequestBody ProductPojo product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(productService.updateProduct(id, product)){
            return ResponseEntity.status(200).body("product updated");
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){

        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }


}
