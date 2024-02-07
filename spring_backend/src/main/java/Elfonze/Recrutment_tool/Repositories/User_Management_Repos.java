package Elfonze.Recrutment_tool.Repositories;

import Elfonze.Recrutment_tool.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Management_Repos extends JpaRepository<User, Integer> {
    //User findByEmail(String email);

    User findByUserName(String userName);
}
