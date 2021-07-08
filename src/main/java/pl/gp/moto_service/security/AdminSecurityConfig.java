package pl.gp.moto_service.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@RequiredArgsConstructor
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/panel/vehicleslist/**")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_name, password, enabled FROM users WHERE user_name = ?")
                .authoritiesByUsernameQuery("SELECT users.user_name, roles.name" + "FORM roles" + "INNER JOIN users ON users.id = users_roles.id " +
                        "WHERE users.user_name");
    }
}
