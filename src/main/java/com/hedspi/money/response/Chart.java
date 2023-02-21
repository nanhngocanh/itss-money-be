package com.hedspi.money.response;

import java.util.ArrayList;
import java.util.List;

public abstract class Chart {
    private List<String> labels = new ArrayList<>();

    public Chart(List<String> labels) {
        this.labels = labels;
    }

    public Chart() {
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
