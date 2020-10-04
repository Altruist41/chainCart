package com.SandhyaJoshi.ShoppingSite.Repository;

import com.SandhyaJoshi.ShoppingSite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //both the parameters are classes (model class and id model class) type of primary key
    Optional<User> findByUsername(String Username);
}
