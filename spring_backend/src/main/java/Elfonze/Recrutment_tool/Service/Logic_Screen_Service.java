package Elfonze.Recrutment_tool.Service;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Logic_Screen_Service {

    @Autowired
    private UserRepository userRepository;
//    public User signUp(User user) {
//        //validate(user);
//        if(userRepository.findByUserName(user.getUserName()) != null){
//            throw new RuntimeException("Username is already taken");
//        }
//
//        if (userRepository.findByEmail(user.getEmail()) != null) {
//            throw new RuntimeException("Email is already registered");
//        }
//        return userRepository.save(user);
//    }


    public ResponseEntity<String> login(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user != null) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
        }
    }


}
