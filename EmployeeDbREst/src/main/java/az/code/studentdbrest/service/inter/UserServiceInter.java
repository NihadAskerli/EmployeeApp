package az.code.studentdbrest.service.inter;

import az.code.studentdbrest.models.User;

import java.util.List;

public interface UserServiceInter {
    User addUser(User user);

    List<User> getAllUsers();
    User getById(Long id);
}
