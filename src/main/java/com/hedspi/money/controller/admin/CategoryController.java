package com.hedspi.money.controller.admin;

import com.hedspi.money.entity.Budget;
import com.hedspi.money.entity.Category;
import com.hedspi.money.entity.Transaction;
import com.hedspi.money.request.createResquest.CreateCategoryRequest;
import com.hedspi.money.request.createResquest.CreateCommonCategoryRequest;
import com.hedspi.money.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> GetCommonBudget(){
        return categoryService.GetCommonCategory();
    }
    @PostMapping("")
    public Category CreateCategory( @RequestBody CreateCommonCategoryRequest createCommonCategoryRequest) {
        return categoryService.CreateCommonCategory(createCommonCategoryRequest);
    }
    @Modifying
    @PutMapping("{Id}")
    public Category UpdateCategory(@PathVariable Integer Id ,@RequestBody CreateCommonCategoryRequest createCommonCategoryRequest) {
        return categoryService.UpdateCommonCategory(Id,createCommonCategoryRequest);
    }
    @DeleteMapping("{Id}")
    public void DeleteCategory(@PathVariable Integer Id) {
        categoryService.DeleteCategory(Id);
    }




}
