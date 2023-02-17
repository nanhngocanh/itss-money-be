package com.hedspi.money.request;

public class CalendarRequest {
    private Integer userId;
    private Integer year;
    private Integer month;

    public CalendarRequest(Integer userId, Integer year, Integer month) {
        this.userId = userId;
        this.year = year;
        this.month = month;
    }

    public CalendarRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
