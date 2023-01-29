package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.Category;
import com.example.ecommerce.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/category/")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("get")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(200).body(categoryService.getCategorys());
    }
    @PostMapping("add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body((message));
        }
        return ResponseEntity.status(200).body("Category Added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = categoryService.updateUser(category.getId(), category);
        if(isUpdated){
            return ResponseEntity.status(200).body("Category updated successfully");
        }else {
            return ResponseEntity.status(400).body(" not found!");
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isDeleted = categoryService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Deleted Successfully");
        }
        return ResponseEntity.status(400).body("Not Found");
    }
}
