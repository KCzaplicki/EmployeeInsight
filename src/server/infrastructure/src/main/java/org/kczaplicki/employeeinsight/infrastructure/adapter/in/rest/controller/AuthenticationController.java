package org.kczaplicki.employeeinsight.infrastructure.adapter.in.rest.controller;

import lombok.RequiredArgsConstructor;
import org.kczaplicki.employeeinsight.application.port.in.AuthenticationUseCase;
import org.kczaplicki.employeeinsight.infrastructure.adapter.in.rest.request.AuthenticateRequest;
import org.kczaplicki.employeeinsight.infrastructure.adapter.in.rest.response.AuthenticateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticateRequest request) {
        String token = authenticationUseCase.authenticate(request.username(), request.password());
        return ResponseEntity.ok(new AuthenticateResponse(token));
    }
}

