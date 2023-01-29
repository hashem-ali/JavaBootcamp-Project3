package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.Category;
import com.example.ecommerce.Pojo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock(){
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock merchantStock ){
        merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStock(String id, MerchantStock merchantStock){
        int counter =0;
        for (MerchantStock cat: merchantStocks) {
            if(cat.getId().equals(id)){
                merchantStocks.set(counter, merchantStock);
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean deleteMerchantStock(String id){
        int counter =0;
        for (MerchantStock cat: merchantStocks) {
            if(cat.getId().equals(id)){
                merchantStocks.remove(cat);
                return true;
            }
            counter++;
        }
        return false;
    }
}
