package com.example.Login_Register_Page.Service;

import com.example.Login_Register_Page.Entity.User;
import com.example.Login_Register_Page.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User saveUser(User user) {


        String password = user.getPassword();
        String hashedPassword = passwordEncoder.encode(password); // Hash the password
        user.setPassword(hashedPassword);
        user.setRole("ROLE_USER");
        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public void removeSessionMessage() {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();

        session.removeAttribute("msg");
    }
}
