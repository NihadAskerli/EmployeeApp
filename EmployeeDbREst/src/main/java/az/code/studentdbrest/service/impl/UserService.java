package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.UserEntity;
import az.code.studentdbrest.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepo userRepo;
    public Optional<UserEntity> findByEmail(String username){
        if(userRepo.findByUsername(username)!=null) {
            return userRepo.findByUsername(username);
        }
        return Optional.empty();

    }
    public void saveUser(UserEntity user){
        String userPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(userPassword);
        userRepo.save(user);

    }
}
