package Elfonze.Recrutment_tool.Repositories;

import Elfonze.Recrutment_tool.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    void deleteAllById(int id);
}
