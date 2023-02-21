package com.hedspi.money.request;

public class ChartRequest {
    private Integer userId;
    private Integer type;
    private String in;
    private Integer year;
    private Integer month;
    private Integer categoryId = 1;

    public ChartRequest(Integer userId, Integer type, String in, Integer year, Integer month, Integer categoryId) {
        this.userId = userId;
        this.type = type;
        this.in = in;
        this.year = year;
        this.month = month;
        this.categoryId = categoryId;
    }

    public ChartRequest() {
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

    public String getIn() {
        return in;
    }

    public void setIn(String by) {
        this.in = by;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
