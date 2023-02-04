package az.code.studentdbrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeDbREstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDbREstApplication.class, args);
    }

}
