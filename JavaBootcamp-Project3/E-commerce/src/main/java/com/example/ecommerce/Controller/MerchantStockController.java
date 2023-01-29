package com.example.ecommerce.Controller;

import com.example.ecommerce.Pojo.MerchantStock;
import com.example.ecommerce.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/merchantstock/")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("get")
    public ResponseEntity addMerchantStockService(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }
    @PostMapping("add")
    public ResponseEntity addMerchantStco(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("MerchantStock added Successfully");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateMerchanStock(@PathVariable String id, @Valid @RequestBody MerchantStock merchantStock,Errors errors ){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       boolean isUpdated = merchantStockService.updateMerchantStock(id, merchantStock);
        if(isUpdated){
        return ResponseEntity.status(200).body("MerchantStock updated successfully");
        }
        return ResponseEntity.status(404).body("MerchantStock Not found");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Deleted Successfully");
        }
        return ResponseEntity.status(404).body("Not Found");
    }
}
