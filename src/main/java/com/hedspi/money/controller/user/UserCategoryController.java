package com.hedspi.money.controller.user;
import com.hedspi.money.entity.Category;
import com.hedspi.money.request.createResquest.CreateCategoryRequest;
import com.hedspi.money.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/app/user")
public class UserCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public List<Category> GetUserPrivateCategory(@RequestParam Integer userId){
        return categoryService.GetUserPrivateCategory(userId);
    }
    @GetMapping("allCategory")
    public List<Category> GetUserCategory(@RequestParam Integer userId){
        return categoryService.GetUserCategory(userId);
    }
    @PostMapping("category")
    public Category CreateCategory( @RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.CreateCategory(createCategoryRequest);
    }
    @Modifying
    @PutMapping("category/{Id}")
    public Category UpdateCategory(@PathVariable Integer Id ,@RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.UpdateCategory(Id,createCategoryRequest);
    }
    @DeleteMapping("category/{Id}")
    public void DeleteCategory(@PathVariable Integer Id) {
        categoryService.DeleteCategory(Id);
    }


}
