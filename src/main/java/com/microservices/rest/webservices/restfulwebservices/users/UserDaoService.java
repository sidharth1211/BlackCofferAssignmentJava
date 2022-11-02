package com.microservices.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Marcus", LocalDate.now().minusYears(40)));
        users.add(new User(3,"Ricky", LocalDate.now().minusYears(50)));
    }

    public List<User>findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findAny().get();
    }
}
