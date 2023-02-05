package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.conf.auth.AuthenticationRequest;
import az.code.studentdbrest.conf.auth.AuthenticationResponse;
import az.code.studentdbrest.conf.auth.RegisterRequest;
import az.code.studentdbrest.models.Role;
import az.code.studentdbrest.models.User;
import az.code.studentdbrest.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest){
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .active(true)
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest registerRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getUsername(),
                        registerRequest.getPassword()
                )
        );
        User user = userRepository.findByUsernameAndAndActiveIsTrue(registerRequest.getUsername());
        String jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder().token(jwtToken).build();
    }
}
