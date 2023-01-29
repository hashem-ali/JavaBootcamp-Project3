package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.Merchant;
import com.example.ecommerce.Pojo.MerchantStock;
import com.example.ecommerce.Pojo.ProductPojo;
import com.example.ecommerce.Pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<>();
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user ){
        users.add(user);
    }

    public boolean updateUser(String id, User user){
        int counter =0;
        for (User use: users) {
            if(use.getId().equals(id)){
                users.set(counter, user);
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean deleteUser(String id){
        int counter =0;
        for (User use: users) {
            if(use.getId().equals(id)){
                users.remove(use);
                return true;
            }
            counter++;
        }
        return false;
    }
    public int addProductToMerchant(String merchantId, String productId, String stockId){
         ArrayList<Merchant> merchants = merchantService.getmerchants();
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStock();
        ArrayList<ProductPojo>  products = productService.getProducts();
        boolean isMerchantStockExisit = false;
        boolean isProductExisit = false;
        boolean isMerchantExisit = false;
        for (Merchant merchant: merchants) {
            if(merchant.getId().isEmpty() || merchant.getId().equals(merchantId)){
                isMerchantExisit = true;
            }
        }
        for (ProductPojo product: products) {
            if(product.getId().isEmpty() || product.getId().equals(productId)){
                isProductExisit = true;
            }
        }
        for (MerchantStock merchantStock: merchantStocks) {
            if(merchantStock.getId().isEmpty() || merchantStock.getId().equals(productId)){
                isMerchantStockExisit = true;
            }
        }

        if(isProductExisit == false || isMerchantExisit == false || isMerchantStockExisit == false){
            return 404;
        }
        if(isProductExisit || isMerchantExisit || isMerchantStockExisit){
            return 200;
        }
        return 400;

    }
    public void addProductToUser( MerchantStock merchantStock, Merchant merchant, ProductPojo product){
//        users.add(user);
        merchantStockService.addMerchantStock(merchantStock);
        merchantService.addMerchant(merchant);
        productService.addProduct(product);

    }

    public String buyProduct(String userId, String merchntId, String productId) {
        ArrayList<Merchant> merchants = merchantService.getmerchants();
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStock();
        ArrayList<ProductPojo> products = productService.getProducts();
        boolean isMerchantStockExisit = false;
        boolean isProductExisit = false;
        boolean isMerchantExisit = false;
//        String idMerchant;
//        String idStock;
//        String idPoduct;
        int indexUser = 0;
        int indexProduct = 0;
        int i;
        for (User user : users) {
             i = 0;
            if (user.getId().isEmpty() || user.getId().equals(userId)) {
                indexUser =i ;
            }
            i++;
        }
        for (Merchant merchant : merchants) {
            if (merchant.getId().isEmpty() || merchant.getId().equals(merchntId)) {
                isMerchantExisit = true;
            }
        }
        int j = 0;
        for (ProductPojo product : products) {
             j = 0;
            if (product.getId().isEmpty() || product.getId().equals(productId)) {
                isProductExisit = true;
                indexProduct = j;
            }
            j++;
        }
        int counter = 0;
        for (MerchantStock merchantStock : merchantStocks) {
            if (merchantStock.getId().isEmpty() || merchantStock.getId().equals(productId)) {
                isMerchantStockExisit = true;
            }
            counter++;
        }
        if (isProductExisit == false || isMerchantExisit == false || isMerchantStockExisit == false) {
            return "Not Valid";
        }

        if(!merchntId.equals(productId)){
            return "Bad Request";
        }
       MerchantStock m  = merchantStocks.get(counter);
        m.setStock(m.getStock()-1);

        User u = users.get(indexUser);
        ProductPojo p = products.get(indexProduct);
        if(u.getBalance() < p.getPrice()){
            return "Bad Request";
        }
        u.setBalance(u.getBalance() - p.getPrice());
        return "buy successfully";

    }

}
