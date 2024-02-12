package Elfonze.Recrutment_tool.Service;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user =  userRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("User Not found"));
       //load user from database

        return user;
    }
}
