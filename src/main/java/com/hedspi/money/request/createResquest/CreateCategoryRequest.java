package com.hedspi.money.request.createResquest;

public class CreateCategoryRequest {
    Integer userId;
    Integer type;
    String name;
    String icon;

    public CreateCategoryRequest() {
    }

    public CreateCategoryRequest(Integer userId, Integer type, String name, String icon) {
        this.userId = userId;
        this.type = type;
        this.name = name;
        this.icon = icon;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }





}
