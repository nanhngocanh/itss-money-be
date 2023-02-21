package com.hedspi.money.service;

import com.hedspi.money.entity.User;
import com.hedspi.money.entity.UserInfo;
import com.hedspi.money.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo getUserInfoById(int id) {
        return userInfoRepository.findById(id).isPresent() ? userInfoRepository.findById(id).get() : null;
    }

    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public void delete(UserInfo userInfo) {
        userInfoRepository.delete(userInfo);
    }

    public List<UserInfo> getAll() {
        return userInfoRepository.findAll();
    }
}
