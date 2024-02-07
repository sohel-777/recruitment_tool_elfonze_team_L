package Elfonze.Recrutment_tool.Repositories;

import Elfonze.Recrutment_tool.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName, String password);

}
