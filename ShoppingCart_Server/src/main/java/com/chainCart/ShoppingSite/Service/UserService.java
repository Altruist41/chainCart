package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(int user_id);

    User findUserByUsername(String username);

    List<User> listAllUsers();

    int numberOfUsers();
}

