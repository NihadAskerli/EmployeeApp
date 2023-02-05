package az.code.studentdbrest.service.inter;

import az.code.studentdbrest.models.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserServiceInter {
    User addUser(User user) throws IOException;

    List<User> getAllUsers() throws IOException;
}
