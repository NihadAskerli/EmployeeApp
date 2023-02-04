package az.code.studentdbrest.repo;

import az.code.studentdbrest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional <User> findByUsernameAndAndActiveIsTrue(String username);
}
