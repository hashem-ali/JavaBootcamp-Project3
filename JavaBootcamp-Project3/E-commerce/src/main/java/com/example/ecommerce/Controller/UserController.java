package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.Merchant;
import com.example.ecommerce.Pojo.MerchantStock;
import com.example.ecommerce.Pojo.ProductPojo;
import com.example.ecommerce.Pojo.User;
import com.example.ecommerce.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("get")
    public ArrayList getUsers(){
        return userService.getUsers();
    }

    @PostMapping("add/{id}")
    public ResponseEntity addUser(@PathVariable String id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@Valid @PathVariable String id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(userService.updateUser(id, user)){
            return ResponseEntity.status(200).body("User updated");
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@Valid @PathVariable String id){
        if(userService.deleteUser(id)){
            return ResponseEntity.status(200).body("user removed");
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }

    @PutMapping("/add/product/merchant/{productId}/{merchantId}/{stockId}")
    public ResponseEntity addProductToMerchant(@PathVariable String productId, @PathVariable String merchantId, @PathVariable String stockId,
                                               @RequestBody MerchantStock merchantStock, @RequestBody Merchant merchant, @RequestBody ProductPojo product){

        int status = userService.addProductToMerchant(merchantId,productId,stockId);
        if(status == 200){
            userService.addProductToUser(merchantStock, merchant, product);
            return ResponseEntity.status(200).body("Product added to merchant stock");
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @PutMapping("/buy/product/merchant/{userId}/{merchantId}/{productId}")
    public ResponseEntity addProductToMerchant( @PathVariable String userId ,@PathVariable String productId, @PathVariable String merchantId){
        return ResponseEntity.status(200).body(userService.buyProduct( userId,merchantId,productId));
    }
}
