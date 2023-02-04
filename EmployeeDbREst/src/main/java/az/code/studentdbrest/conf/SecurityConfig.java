package az.code.studentdbrest.conf;

import az.code.studentdbrest.models.Role;
import az.code.studentdbrest.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.EnumSet;
import java.util.function.IntFunction;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Slf4j
public class SecurityConfig {

@Bean
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
    @Bean
    public UserDetailsService userDetailsService( UserRepo userRepo) {
        return username -> {
            return userRepo.findByUsernameAndAndActiveIsTrue(username).map(user -> User.builder()
                    .username(user.getUsername())
                    .password(user .getPassword())
                    .roles(user.getRoles().stream().map(Role::toString).toArray(String[]::new))
                    .build()).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        };
    }


}
