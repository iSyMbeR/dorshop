package pl.dorshop.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pl.dorshop.shop.model.UserType;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password1")
                .roles(UserType.NORMAL_USER.name())
                .build();

        UserDetails moderator = User.withDefaultPasswordEncoder()
                .username("moderator")
                .password("moderator")
                .roles(UserType.MODERATOR.name())
                .build();

        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles(UserType.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails, moderator);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/users").permitAll()
                .antMatchers(HttpMethod.POST,"/users").hasAnyRole(UserType.MODERATOR.name(), UserType.ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/users").hasRole(UserType.ADMIN.name())
                .anyRequest().hasRole(UserType.ADMIN.name())
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
        .and()
        .csrf().disable();
    }
}
