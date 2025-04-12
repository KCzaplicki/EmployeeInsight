package org.kczaplicki.employeeinsight.application.service;

import lombok.RequiredArgsConstructor;
import org.kczaplicki.employeeinsight.application.port.out.security.JwtServicePort;
import org.kczaplicki.employeeinsight.domain.model.User;
import org.kczaplicki.employeeinsight.application.port.in.AuthenticationUseCase;
import org.kczaplicki.employeeinsight.application.port.out.persistence.UserRepositoryPort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    private final UserRepositoryPort userRepository;
    private final JwtServicePort jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && passwordMatches(user.get(), password)) {
            return jwtService.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public boolean validateToken(String token) {
        return jwtService.validateToken(token);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return jwtService.extractUsername(token);
    }

    private boolean passwordMatches(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
