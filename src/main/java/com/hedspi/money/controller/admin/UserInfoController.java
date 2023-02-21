package com.hedspi.money.controller.admin;

import com.hedspi.money.entity.UserInfo;
import com.hedspi.money.repository.UserInfoRepository;
import com.hedspi.money.request.UserInfoRequest;
import com.hedspi.money.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserInfoById(@PathVariable("id") int id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        if (userInfo == null) {
            return ResponseEntity.notFound().build();
        } else {
            Map<String, String> data = new HashMap<>();
            data.put("first_name", userInfo.getFirstName());
            data.put("last_name", userInfo.getLastName());
            data.put("sex", userInfo.getSex());
            data.put("phone_number", userInfo.getPhoneNumber());
            data.put("date_of_birth", userInfo.getDateOfBirth());
            return ResponseEntity.ok(data);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserInfo(@PathVariable("id") int id, @RequestBody UserInfoRequest userInfoRequest) {
        UserInfo userInfo1 = userInfoService.getUserInfoById(id);
        if (userInfo1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            if (userInfoRequest.getFirst_name() != null)
                userInfo1.setFirstName(userInfoRequest.getFirst_name());
            if (userInfoRequest.getLast_name() != null)
                userInfo1.setLastName(userInfoRequest.getLast_name());
            if (userInfoRequest.getSex() != null)
                userInfo1.setSex(userInfoRequest.getSex());
            if (userInfoRequest.getPhone_number() != null)
                userInfo1.setPhoneNumber(userInfoRequest.getPhone_number());
            if (userInfoRequest.getDate_of_birth() != null)
                userInfo1.setDateOfBirth(userInfoRequest.getDate_of_birth());
            userInfoService.save(userInfo1);
            return ResponseEntity.ok("{\"message\": \"Update successfully\"}");
        }
    }


    public void deleteUserInfo(int id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        if (userInfo != null) {
            userInfoService.delete(userInfo);
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllUserInfo() {
        Map<String, Object> data = new HashMap<>();
        List<UserInfo> userInfos = userInfoService.getAllUser();
        if (userInfos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            userInfos.forEach(UserInfo -> UserInfo.getUser().setPassword(null));
            data.put("userInfos", userInfos);
            return ResponseEntity.ok(data);
        }
    }
}