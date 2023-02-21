package com.hedspi.money.repository;

import com.hedspi.money.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    @Query("select u from UserInfo u where u.user.role = 'user'")
    List<UserInfo> getAllUser();
}