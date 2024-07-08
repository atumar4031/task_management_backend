package com.attech.auth;

import com.attech.model.AppResponse;

public interface AuthService {
    AppResponse register(RegisterRequest registerRequest);
    AppResponse login(LoginRequest loginRequest);
}
