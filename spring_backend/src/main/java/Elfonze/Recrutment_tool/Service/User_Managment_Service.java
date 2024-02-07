package Elfonze.Recrutment_tool.Service;

import Elfonze.Recrutment_tool.Models.User;
import Elfonze.Recrutment_tool.Repositories.User_Management_Repos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_Managment_Service {

    @Autowired
    private User_Management_Repos user_management_repos;
    public User signUp(User user) {
        User nuser = user_management_repos.findByUserName(user.getUserName());
        if (nuser != null) {
            throw new RuntimeException("Email is already registered");
        }
        user = user_management_repos.save(user);
        return user;
    }
}
