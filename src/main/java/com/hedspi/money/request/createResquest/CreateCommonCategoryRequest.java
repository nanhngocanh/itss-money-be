package com.hedspi.money.request.createResquest;

public class CreateCommonCategoryRequest {
    Integer type;
    String name;
    String icon;

    public CreateCommonCategoryRequest() {
    }

    public CreateCommonCategoryRequest(Integer type, String name, String icon) {
        this.type = type;
        this.name = name;
        this.icon = icon;
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
