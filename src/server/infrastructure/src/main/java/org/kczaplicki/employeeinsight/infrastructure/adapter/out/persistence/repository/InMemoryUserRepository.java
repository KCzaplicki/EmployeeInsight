package org.kczaplicki.employeeinsight.infrastructure.adapter.out.persistence.repository;

import org.kczaplicki.employeeinsight.domain.model.User;
import org.kczaplicki.employeeinsight.application.port.out.persistence.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Repository
public class InMemoryUserRepository implements UserRepositoryPort {

    private final Map<String, User> users = new HashMap<>(Map.of(
            "user", new User("1", "user", "$2a$10$r/qsFMZcevqzLI4nofqTpuXwIktMTmuo0C5R7od7pvdiidXU60FeK", emptyList())
    ));

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
