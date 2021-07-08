package pl.gp.moto_service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.gp.moto_service.entity.User;
import pl.gp.moto_service.repository.user.UserServices;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserServices userServices;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userServices.findUserByUserName(username);

        if (user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MotoUserDetails(user);
    }
}
