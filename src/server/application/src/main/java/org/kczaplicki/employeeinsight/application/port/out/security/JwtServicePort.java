package org.kczaplicki.employeeinsight.application.port.out.security;

public interface JwtServicePort {

    String generateToken(String username);
    boolean validateToken(String token);
    String extractUsername(String token);
}
