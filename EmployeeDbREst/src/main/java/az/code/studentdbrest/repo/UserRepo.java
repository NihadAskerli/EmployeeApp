package az.code.studentdbrest.repo;

import az.code.studentdbrest.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
     Optional<UserEntity> findByUsername(String username);
}
