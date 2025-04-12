package org.kczaplicki.employeeinsight.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String password;

    private Collection<String> roles;
}
