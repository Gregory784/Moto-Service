package pl.gp.moto_service.repository.user;

import pl.gp.moto_service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    public User findUserByUserName(String userName);
    public User createUser(User user);
    public void deleteUserById(Long id);
    public List<User> findUsers();
}
