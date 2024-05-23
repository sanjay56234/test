package SplitWise.entities.User;

import java.util.ArrayList;
import java.util.List;
public class UserController {
    List<User> users;

    public UserController(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
       users.add(user);
    }

    public User getUser(String id){
        for(User user : users){
            if(user.userId==id) return user;
        }
        return null;
    }

    public List<User> getAllUser(){
        return users;
    }
}
