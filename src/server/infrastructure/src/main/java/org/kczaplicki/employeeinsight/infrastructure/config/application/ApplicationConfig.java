package org.kczaplicki.employeeinsight.infrastructure.config.application;

import org.kczaplicki.employeeinsight.application.port.in.AuthenticationUseCase;
import org.kczaplicki.employeeinsight.application.port.out.persistence.UserRepositoryPort;
import org.kczaplicki.employeeinsight.application.port.out.security.JwtServicePort;
import org.kczaplicki.employeeinsight.application.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationUseCase authenticationService(
            UserRepositoryPort userRepository,
            JwtServicePort jwtService,
            PasswordEncoder passwordEncoder) {
        return new AuthenticationService(userRepository, jwtService, passwordEncoder);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
