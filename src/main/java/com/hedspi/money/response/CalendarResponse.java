package com.hedspi.money.response;

public class CalendarResponse {
    private Integer day;
    private Integer thu;
    private Integer chi;

    public CalendarResponse(Integer day, Integer thu, Integer chi) {
        this.day = day;
        this.thu = thu;
        this.chi = chi;
    }

    public CalendarResponse() {
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getThu() {
        return thu;
    }

    public void setThu(Integer thu) {
        this.thu = thu;
    }

    public Integer getChi() {
        return chi;
    }

    public void setChi(Integer chi) {
        this.chi = chi;
    }
}
