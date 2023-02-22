package com.hedspi.money.controller.auth;

import com.hedspi.money.entity.User;
import com.hedspi.money.request.auth.ChangePasswordRequest;
import com.hedspi.money.request.auth.LoginRequest;
import com.hedspi.money.request.auth.RegisterRequest;
import com.hedspi.money.response.auth.LoginResponse;
import com.hedspi.money.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String signup(@RequestBody RegisterRequest registerRequest){
        return authService.signup(registerRequest);
    }

    @PutMapping("/changePassword")
    public String changePass(@RequestBody ChangePasswordRequest changePasswordRequest){
        return authService.changePass(changePasswordRequest);
    }


}
