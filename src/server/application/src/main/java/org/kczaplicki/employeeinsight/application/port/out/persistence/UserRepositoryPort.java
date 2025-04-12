package org.kczaplicki.employeeinsight.application.port.out.persistence;

import org.kczaplicki.employeeinsight.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findByUsername(String username);
}
