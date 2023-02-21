package com.hedspi.money.response;

import java.util.ArrayList;
import java.util.List;

public class PieChartResponse extends Chart {
    private List<String> labels = new ArrayList<>();
    private List<Integer> data = new ArrayList<>();

    public PieChartResponse(List<String> labels, List<String> labels1, List<Integer> data) {
        super(labels);
        this.labels = labels1;
        this.data = data;
    }

    public PieChartResponse(List<String> labels, List<Integer> data) {
        this.labels = labels;
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
