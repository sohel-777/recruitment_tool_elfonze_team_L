package Elfonze.Recrutment_tool.Controller;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Service.Logic_Screen_Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "/user")
public class Logic_Screen_Controller {

    @Autowired
    private Logic_Screen_Service userService;


    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String password){
        try {
            return userService.login(userName, password);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
//        try {
//            User user = userService.findByEmail(email);
//
//            if (user == null) {
//                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//            }
//
//            // Generate a simple reset link
//            String resetLink = "http://your-app/reset-password";
//
//            // Send an email with the reset link
//            String emailBody = "Click the following link to reset your password: " + resetLink;
//            //emailService.sendEmail(user.getEmail(), "Password Reset", emailBody);
//
//            return new ResponseEntity<>("Password reset email sent successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error sending reset email", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
