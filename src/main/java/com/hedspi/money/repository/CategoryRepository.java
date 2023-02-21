package com.hedspi.money.repository;

import com.hedspi.money.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where (c.userId = :userid OR c.userId = null) and c.type =:type")
    List<Category> GetUserCategory(Integer userid, Integer type);
    @Query("select c from Category c where c.userId = :userid")
    List<Category> GetUserPrivateCategory(Integer userid);
    @Query("select c from Category c where c.userId = null")
    List<Category> GetCommonCategory();
    @Query("SELECT MAX(c.id) from Category c")
    int GetMaxCategoryId();


}