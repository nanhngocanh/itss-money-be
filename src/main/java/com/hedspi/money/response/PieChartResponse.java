package com.hedspi.money.response;

import java.util.ArrayList;
import java.util.List;

public class PieChartResponse extends Chart {
    private List<Integer> data = new ArrayList<>();

    public PieChartResponse(List<String> labels, List<Integer> data) {
        super(labels);
        this.data = data;
    }

    public PieChartResponse(){}
    public PieChartResponse(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
