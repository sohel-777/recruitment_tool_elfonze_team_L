package Elfonze.Recrutment_tool.Controller;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Service.User_Managment_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/userManagement")
public class User_Managment_Controller {

    @Autowired
    private User_Managment_Service user_managment_service;

    @PostMapping(path = "/signUp/SuperAdmin")
    public ResponseEntity<String> signUpSuperAdmin(@RequestBody User user) {
        try{
             user_managment_service.signUp(user);
            return new ResponseEntity<>("Super Admin Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }

    //create
    @PostMapping(path = "/signUp/user")
    public ResponseEntity<String> signUpUser(@RequestBody User user) {
        try{
            user_managment_service.signUp(user);
            return new ResponseEntity<>("User Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/signUp/Admin")
    public ResponseEntity<String> signUpAdmin(@RequestBody User user) {
        try{
            user_managment_service.signUp(user);
            return new ResponseEntity<>("Admin Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }

    //update
    //delete
    //approve
}
