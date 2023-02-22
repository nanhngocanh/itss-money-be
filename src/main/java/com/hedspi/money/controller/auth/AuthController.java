package com.hedspi.money.controller.auth;

import com.hedspi.money.entity.User;
import com.hedspi.money.request.auth.LoginRequest;
import com.hedspi.money.request.auth.RegisterRequest;
import com.hedspi.money.response.auth.LoginResponse;
import com.hedspi.money.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
    }



}
