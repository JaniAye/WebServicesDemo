package com.tryservices.rest.webservices.demos.user;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users=new ArrayList<>();

    private static  int userCount = 4;
    static {
        users.add(new User(1,"JAni",new Date()));
        users.add(new User(2,"Aye",new Date()));
        users.add(new User(3,"hy",new Date()));
        users.add(new User(4,"sa",new Date()));
    }

    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        if (user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user:users) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User DeleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user=iterator.next();

            if (user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
