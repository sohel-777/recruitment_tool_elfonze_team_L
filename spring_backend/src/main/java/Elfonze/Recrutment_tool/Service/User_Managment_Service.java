package Elfonze.Recrutment_tool.Service;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class User_Managment_Service {

    @Autowired
    private UserRepository userRepository;

    public User signUp(User user) {
        Optional<User> nuser = userRepository.findByUserName(user.getUsername());
        if (nuser != null) {
            throw new RuntimeException("Email is already registered");
        }
        user = userRepository.save(user);
        return user;
    }

    public void updateInfo(User user, String email, String password) {
          user.setEmail(email);
          user.setPassword(password);
          userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteAllById(id);
    }

    public ResponseEntity<String> login(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user != null) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
