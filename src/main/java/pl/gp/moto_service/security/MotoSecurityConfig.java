package pl.gp.moto_service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@RequiredArgsConstructor
@Order(1)
public class MotoSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/panel/vehicleslist/**")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasAnyRole("ADMIN","USER");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
