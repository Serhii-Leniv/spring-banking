package org.serhiileniv.banking.service;

import org.serhiileniv.banking.dto.AuthResponse;
import org.serhiileniv.banking.dto.RegisterRequest;
import org.serhiileniv.banking.model.User;
import org.serhiileniv.banking.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService,EmailService emailService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.emailService = emailService;
    }


    public AuthResponse register(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.password());
        String vCode = String.valueOf(new Random().nextInt(900000) + 100000);
        User user = new User(
                null,
            request.name(),
                request.surname(),
                request.email(),
                request.phone(),
                encodedPassword,
                LocalDateTime.now()
        );
        user.setVerificationCode(vCode);
        emailService.setVerificationEmail(user.getEmail(), vCode);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken,user.getEmail(),user.getName());

    }
}
