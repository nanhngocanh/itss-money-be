package com.hedspi.money.request.createResquest;

public class CreateBudgetRequest {
    Integer userId;
    Integer categoryId;
    Integer amount;
    String budgetTime;

    public CreateBudgetRequest() {
    }

    public CreateBudgetRequest(Integer userId, Integer categoryId, Integer amount, String budgetTime) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.budgetTime = budgetTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBudgetTime() {
        return budgetTime;
    }

    public void setBudgetTime(String budgetTime) {
        this.budgetTime = budgetTime;
    }
}
