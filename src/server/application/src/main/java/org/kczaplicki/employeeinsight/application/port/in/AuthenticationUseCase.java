package org.kczaplicki.employeeinsight.application.port.in;

public interface AuthenticationUseCase {

    String authenticate(String username, String password);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
}
