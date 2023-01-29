package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.ProductPojo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<ProductPojo> products = new ArrayList<>();

    public ArrayList<ProductPojo> getProducts(){
        return products;
    }

    public void addProduct(ProductPojo product ){
        products.add(product);
    }

    public boolean updateProduct(String id, ProductPojo product){
        int counter =0;
        for (ProductPojo pro: products) {
            if(pro.getId().equals(id)){
                products.set(counter, product);
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean deleteProduct(String id){
        int counter =0;
        for (ProductPojo pro: products) {
            if(pro.getId().equals(id)){
                products.remove(pro);
                return true;
            }
            counter++;
        }
        return false;
    }
}
