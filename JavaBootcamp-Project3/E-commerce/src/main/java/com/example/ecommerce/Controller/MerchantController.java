package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.Merchant;
import com.example.ecommerce.Service.MerchantService;
import com.example.ecommerce.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/merchant/")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping("get")
    public ResponseEntity getMerchants(){
        return ResponseEntity.status(200).body(merchantService.getmerchants());
    }


    @PostMapping("add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant Added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id, @Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = merchantService.updateMerchant(id, merchant);
        if(isUpdated) {
            return ResponseEntity.status(200).body("Merchant updated successfully");
        }else {
            return ResponseEntity.status(404).body(" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){

        boolean isDeleted = merchantService.deleteMerchant(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }

}
