package com.hedspi.money.response;

import java.util.ArrayList;
import java.util.List;

public class BarChartResponse extends Chart {
    private List<Integer> amount = new ArrayList<>();
    private List<Integer> budget = new ArrayList<>();

    public BarChartResponse(List<String> labels, List<Integer> amount, List<Integer> budget) {
        super(labels);
        this.amount = amount;
        this.budget = budget;
    }

    public BarChartResponse(List<Integer> amount, List<Integer> budget) {
        this.amount = amount;
        this.budget = budget;
    }

    public BarChartResponse(){
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public void setAmount(List<Integer> amount) {
        this.amount = amount;
    }

    public List<Integer> getBudget() {
        return budget;
    }

    public void setBudget(List<Integer> budget) {
        this.budget = budget;
    }
}
