package com.hedspi.money.controller.user;

import com.hedspi.money.entity.UserInfo;
import com.hedspi.money.request.UserInfoRequest;
import com.hedspi.money.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/user")
public class UserTest {

    @Autowired
    UserInfoService userInfoService;

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
            userInfoService.save(userInfo1);
            return ResponseEntity.ok("{\"message\": \"Update successfully\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserInfo(@PathVariable("id") int id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        if (userInfo == null) {
            return ResponseEntity.notFound().build();
        } else {
            userInfoService.delete(userInfo);
            return ResponseEntity.ok("{\"message\": \"Delete successfully\"}");
        }
    }
}