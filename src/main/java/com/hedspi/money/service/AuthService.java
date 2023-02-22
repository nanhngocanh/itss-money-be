package com.hedspi.money.service;

import com.hedspi.money.entity.User;
import com.hedspi.money.entity.UserInfo;
import com.hedspi.money.entity.Wallet;
import com.hedspi.money.repository.UserInfoRepository;
import com.hedspi.money.repository.UserRepository;
import com.hedspi.money.repository.WalletRepository;
import com.hedspi.money.request.auth.LoginRequest;
import com.hedspi.money.request.auth.RegisterRequest;
import com.hedspi.money.response.auth.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private WalletRepository walletRepository;

    public LoginResponse login(LoginRequest loginRequest){
        User user = userRepository.getUserByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if (passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            UserInfo userInfo = userInfoRepository.findById(user.getId()).get();
            Wallet wallet = walletRepository.getWalletByUserId(user.getId());
            loginResponse.setId(user.getId());
            loginResponse.setEmail(user.getEmail());
            loginResponse.setName(userInfo.getFirstName()+ " " +userInfo.getLastName());
            loginResponse.setRole(user.getRole());
            loginResponse.setWalletId(wallet.getId());
            return loginResponse;
        }
        return null;
    }

    public void signup(RegisterRequest registerRequest){
        User user = new User();
        Wallet wallet = new Wallet();
        UserInfo userInfo = new UserInfo();

        user.setEmail(registerRequest.getEmail());
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);

        userInfo.setUser(user);
        userInfo.setFirstName(registerRequest.getFirstName());
        userInfo.setLastName(registerRequest.getLastName());
        userInfo.setSex(registerRequest.getSex());
        userInfo.setPhoneNumber(registerRequest.getPhoneNumber());
        userInfo.setDateOfBirth(registerRequest.getDateOfBirth());
        userInfoRepository.save(userInfo);

        wallet.setUserId(user.getId());
        wallet.setAmount(registerRequest.getAmount());
        walletRepository.save(wallet);
    }
}
