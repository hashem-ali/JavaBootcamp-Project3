package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.User;
import com.example.ecommerce.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    UserService users;
    public UserController(UserService users){
        this.users = users;
    }
    @GetMapping("get")
    public ArrayList getUsers(){
        return users.getUsers();
    }

    @PostMapping("add/{id}")
    public ResponseEntity addUser(@PathVariable String id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        users.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@Valid @PathVariable String id, @Valid @RequestBody User user){
        if(users.updateUser(id, user)){
            return ResponseEntity.status(200).body("User updated");
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@Valid @PathVariable String id){
        if(users.deleteUser(id)){
            return ResponseEntity.status(200).body("user removed");
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
}
