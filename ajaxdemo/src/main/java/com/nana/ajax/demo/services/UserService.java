package com.nana.ajax.demo.services;

import com.nana.ajax.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users;

    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
        return result;

    }

    @PostConstruct
    private void initDataForTesting() {

        users = new ArrayList<>();

        User user1 = new User ("mkyong", "password111", "myyong@gmail.com");
        User user2 = new User ("flfow", "password222", "222@gmail.com");
        User user3 = new User ("daga", "password333", "333@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }


}
