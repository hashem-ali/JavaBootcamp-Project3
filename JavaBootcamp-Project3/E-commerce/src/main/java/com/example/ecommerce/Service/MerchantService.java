package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getmerchants(){
        return merchants;
    }


    public void addMerchant(Merchant Merchant ){
        merchants.add(Merchant);
    }

    public boolean updateMerchant(String id, Merchant Merchant){
        int counter =0;
        for (Merchant mer: merchants) {
            if(mer.getId().equals(id)){
                merchants.set(counter, Merchant);
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean deleteMerchant(String id){
        int counter =0;
        for (Merchant mer: merchants) {
            if(mer.getId().equals(id)){
                merchants.remove(mer);
                return true;
            }
            counter++;
        }
        return false;
    }
}
