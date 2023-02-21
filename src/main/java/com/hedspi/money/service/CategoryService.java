package com.hedspi.money.service;

import com.hedspi.money.entity.Category;
import com.hedspi.money.repository.CategoryRepository;
import com.hedspi.money.request.createResquest.CreateCategoryRequest;
import com.hedspi.money.request.createResquest.CreateCommonCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category CreateCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();

        category.setId (1 + categoryRepository.GetMaxCategoryId());
        category.setName(createCategoryRequest.getName());
        category.setIcon(createCategoryRequest.getIcon());
        category.setType(createCategoryRequest.getType());
        category.setUserId(createCategoryRequest.getUserId());
        category.setCreateAt(Instant.now());
        category.setUpdateAt(Instant.now());

        return categoryRepository.save(category);
    }
    public Category UpdateCategory(Integer Id,CreateCategoryRequest createCategoryRequest) {
        Category category = categoryRepository.findById(Id).get();
        category.setName(createCategoryRequest.getName());
        category.setIcon(createCategoryRequest.getIcon());
        category.setType(createCategoryRequest.getType());
        category.setUserId(createCategoryRequest.getUserId());
        category.setUpdateAt(Instant.now());

        return categoryRepository.save(category);
    }
    public void DeleteCategory(Integer Id) {
        Category category = categoryRepository.findById(Id).get();
        categoryRepository.delete(category);
    }

    public Category CreateCommonCategory(CreateCommonCategoryRequest createCommonCategoryRequest) {
        Category category = new Category();

        category.setId (1 + categoryRepository.GetMaxCategoryId());
        category.setName(createCommonCategoryRequest.getName());
        category.setIcon(createCommonCategoryRequest.getIcon());
        category.setType(createCommonCategoryRequest.getType());
        category.setUserId(null);
        category.setCreateAt(Instant.now());
        category.setUpdateAt(Instant.now());

        return categoryRepository.save(category);
    }
    public Category UpdateCommonCategory(Integer Id,CreateCommonCategoryRequest createCommonCategoryRequest) {
        Category category = categoryRepository.findById(Id).get();
        category.setName(createCommonCategoryRequest.getName());
        category.setIcon(createCommonCategoryRequest.getIcon());
        category.setType(createCommonCategoryRequest.getType());
        category.setUserId(null);
        category.setUpdateAt(Instant.now());
        return categoryRepository.save(category);
    }
    public List<Category> GetCommonCategory(){
        return categoryRepository.GetCommonCategory();
    }
    public List<Category> GetUserCategory(Integer userId, Integer type){
        return categoryRepository.GetUserCategory(userId,type);
    }
    public List<Category> GetUserPrivateCategory(Integer userId){
        return categoryRepository.GetUserPrivateCategory(userId);

    }


}
