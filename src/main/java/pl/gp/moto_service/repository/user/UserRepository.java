package pl.gp.moto_service.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gp.moto_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByUserName(String userName);
}
