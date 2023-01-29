package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.Category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategorys(){
        return categories;
    }

    public void addCategory(Category category ){
        categories.add(category);
    }

    public boolean updateUser(String id, Category category){
        int counter =0;
        for (Category use: categories) {
            if(use.getId().equals(id)){
                categories.set(counter, category);
                return true;
            }
            counter++;
        }
        return false;
    }

    public boolean deleteUser(String id){
        int counter =0;
        for (Category use: categories) {
            if(use.getId().equals(id)){
                categories.remove(use);
                return true;
            }
            counter++;
        }
        return false;
    }
}
