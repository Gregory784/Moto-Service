package pl.gp.moto_service.repository.user;

import lombok.AllArgsConstructor;
import pl.gp.moto_service.entity.User;

import java.util.List;

@AllArgsConstructor
public class UserImplRepository implements UserServices {
    private final UserRepository userRepository;
    @Override
    public User findUserByUserName(final String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
