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
        user.setRole("Super Admin");

        try{
            user_managment_service.signUp(user);
            return new ResponseEntity<>("Super Admin Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/signUp/Admin")
    public ResponseEntity<String> signUpAdmin(@RequestBody User user) {
        user.setRole("Admin");

        try{
            user_managment_service.signUp(user);
            return new ResponseEntity<>("Admin Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }
    //create
    @PostMapping(path = "/signUp/user")
    public ResponseEntity<String> signUpUser(@RequestBody User user) {

        user.setRole("User");
        try{
            user_managment_service.signUp(user);
            return new ResponseEntity<>("User Signup Successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
        }
    }


    //login
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String password){
        try {
            return user_managment_service.login(userName, password);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get user by username
    @GetMapping("/get")
    public String getUser(){
        System.out.println("getting users");
        return "User";
    }

    //update user info
    @PutMapping("/updateInfo")
    public ResponseEntity<String> updateInformation(@RequestBody User user, @RequestBody String Email, @RequestBody String password){

       try{
           user_managment_service.updateInfo(user, Email, password);
           return new ResponseEntity<>("Email and Password Update Successfully", HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>("Wrong Information Provided",HttpStatus.BAD_REQUEST);
       }
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Integer id ){
        try{
            user_managment_service.delete(id);
            return new ResponseEntity<>("User deleted SSuccessfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User Not Deleted ", HttpStatus.BAD_REQUEST);
        }
    }
    //approve
}
