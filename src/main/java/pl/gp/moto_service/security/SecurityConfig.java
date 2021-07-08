package pl.gp.moto_service.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{bcrypt}$2y$06$yF2AWvO3ptZdpQTvjvRFlO81xxl.NgRHC2QnNTEwUhMfkzW9Twb.W")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("{bcrypt}$2y$06$5/kGNogT0kBnT0tmLbk10.wpo46fegszSU6oqDpcGDyBPVWgabSYm ")
                .roles("USER");
    }
}
