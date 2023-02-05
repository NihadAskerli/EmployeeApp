package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.User;
import az.code.studentdbrest.service.inter.UserServiceInter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Profile("file")
@Slf4j
public class FileUserService implements UserServiceInter {
    private final ObjectMapper objectMapper;

    @Override
    public User addUser(User user)  {
        try {
            objectMapper. writeValue(new File("C:\\Nihad\\GithubProjes\\EmployeeApp\\EmployeeDbREst\\user.txt"), user);
        } catch (IOException e) {
            log.info("runtime exception bas verdi");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers()  {
        List<User> list= new ArrayList<>();
        User user= null;
        try {
            user = objectMapper.readValue(new File("C:\\Nihad\\GithubProjes\\EmployeeApp\\EmployeeDbREst\\user.txt"), User.class);
        } catch (IOException e) {
            log.info("happen runttime exception");
        }
        list.add(user);
        return list;
    }

}
