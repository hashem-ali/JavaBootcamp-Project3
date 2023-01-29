package com.example.ecommerce.Service;

import com.example.ecommerce.Pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<>();

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
}
