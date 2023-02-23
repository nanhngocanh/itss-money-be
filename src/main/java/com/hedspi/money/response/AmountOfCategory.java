package com.hedspi.money.response;

public class AmountOfCategory {
    private String category;
    private Integer amount;

    public AmountOfCategory(String category, long amount) {
        this.category = category;
        this.amount = (int)amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
