package com.hedspi.money.controller.user;

import com.hedspi.money.entity.Budget;
import com.hedspi.money.entity.Category;
import com.hedspi.money.request.createResquest.CreateBudgetRequest;
import com.hedspi.money.request.createResquest.CreateCategoryRequest;
import com.hedspi.money.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserBudgetController {
    @Autowired
    private BudgetService budgetService;

    //loi can sua
    @GetMapping("budget")
    public List<Budget> GetUserBudget(@RequestParam Integer userId){
        return budgetService.GetUserBudget(userId);
    }

    @PostMapping("budget")
    public Budget CreateBudget(@RequestBody CreateBudgetRequest createBudgetRequest) {
        return budgetService.CreateBudget(createBudgetRequest);
    }
    @PutMapping("budget/{Id}")
    public Integer UpdateBudget(@PathVariable Integer Id ,@RequestBody  CreateBudgetRequest createBudgetRequest) {
        return budgetService.UpdateBudget(Id,createBudgetRequest);
    }
    @DeleteMapping("budget/{Id}")
    public void UpdateBudget(@PathVariable Integer Id) {
        budgetService.DeleteBudget(Id);
    }

}
