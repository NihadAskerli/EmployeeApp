package az.code.studentdbrest.conf;
import az.code.studentdbrest.repo.UserRepo;;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public interface SecurityConfigInter {


    BCryptPasswordEncoder bCryptPasswordEncoder();

    UserDetailsService userDetailsService(UserRepo userRepository);


}
