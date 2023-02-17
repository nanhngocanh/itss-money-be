package com.hedspi.money.controller.admin;

import com.hedspi.money.entity.UserInfo;
import com.hedspi.money.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserInfoController userInfoController;

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
        userInfoController.deleteUserInfo(id);
        userService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Delete successfully\"}");
    }
}
