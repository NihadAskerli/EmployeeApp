package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.dto.UserDto;
import az.code.studentdbrest.models.User;
import az.code.studentdbrest.repo.UserRepo;
import az.code.studentdbrest.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Profile("!file")
public class DBUserService implements UserServiceInter {

    private final UserRepo userRepo;

    @Override
    public User addUser(User user) {
      String password =new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
