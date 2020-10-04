package com.SandhyaJoshi.ShoppingSite.Service;
import com.SandhyaJoshi.ShoppingSite.Model.User;
import com.SandhyaJoshi.ShoppingSite.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired //dependency injection
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(final User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); //getter and setter
        return userRepository.save(user);  //save function in JpaRepository class
    }

    @Override
    public User updateUser(final User user){
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(final int user_id){
        userRepository.deleteById(user_id);
    }

    @Override
    public User findUserByUsername(final String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public int numberOfUsers(){
        return (int)userRepository.count();
    }

}
