package com.kcc.restfulservice;

import com.kcc.restfulservice.bean.User;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1,"kim", new Date(), "pass1", "708080-1122331"));
        users.add(new User(2,"park", new Date(),"pass2", "708080-1122332"));
        users.add(new User(3,"moon", new Date(),"pass3", "708080-1122333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++userCount);
        }

        if(user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }

        users.add(user);

        return user;
    }

    public User findOne(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User deleteUser(int id) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }


}
