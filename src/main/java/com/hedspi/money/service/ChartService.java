package com.hedspi.money.service;

import com.hedspi.money.entity.Category;
import com.hedspi.money.repository.BudgetRepository;
import com.hedspi.money.repository.CategoryRepository;
import com.hedspi.money.repository.TransactionRepository;
import com.hedspi.money.request.ChartRequest;
import com.hedspi.money.response.BarChartResponse;
import com.hedspi.money.response.PieChartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChartService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public BarChartResponse getBarChart(ChartRequest chartRequest){
        if (chartRequest.getIn().equals("year")) return barChartInYear(chartRequest);
        return barChartInMonth(chartRequest);
    }

    private BarChartResponse barChartInYear(ChartRequest chartRequest){
        BarChartResponse barChartResponse = new BarChartResponse();
        List<Integer> amount = new ArrayList<>();
        List<Integer> budget = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        String month;
        if (chartRequest.getCategoryId().equals(0)){
            for (int i = 1; i <= 12; i++) {
                if (i < 10) month = "0" + i; else month = ""+i;
                labels.add("T"+i);
                addItem(amount,transactionRepository.getSumTransactionOfMonthByType(chartRequest.getUserId(),chartRequest.getYear(),i,chartRequest.getType()));
                addItem(budget, budgetRepository.getSumBudgetInMonth(chartRequest.getUserId(),chartRequest.getYear() + "-" + month));
            }
        } else {
            for (int i = 1; i <= 12; i++) {
                if (i < 10) month = "0" + i; else month = ""+i;
                labels.add("T"+i);
                addItem(amount,transactionRepository.getSumTransactionOfMonthByTypeAndCategory(chartRequest.getUserId(),chartRequest.getYear(),i,chartRequest.getType(),chartRequest.getCategoryId()));
                addItem(budget, budgetRepository.getSumBudgetInMonthByCategory(chartRequest.getUserId(), chartRequest.getYear()+"-"+month,chartRequest.getCategoryId()));
            }
        }
        if (chartRequest.getType().equals(-1)) barChartResponse.setBudget(budget);
        barChartResponse.setLabels(labels);
        barChartResponse.setAmount(amount);
        return barChartResponse;
    }

    private BarChartResponse barChartInMonth(ChartRequest chartRequest){
        BarChartResponse barChartResponse = new BarChartResponse();
        List<Integer> amount = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        Integer daysInMonth = YearMonth.of(chartRequest.getYear(), chartRequest.getMonth()).lengthOfMonth();
        if (chartRequest.getCategoryId().equals(0)){
            for (int i = 1; i <= daysInMonth; i++) {
                labels.add(""+i);
                addItem(amount, transactionRepository.getSumTransactionOfDayByType(chartRequest.getUserId(),chartRequest.getYear(),chartRequest.getMonth(),i,chartRequest.getType()));
            }
        } else {
            for (int i = 1; i <= daysInMonth; i++) {
                labels.add(""+i);
                addItem(amount, transactionRepository.getSumTransactionOfDayByTypeAndCategory(chartRequest.getUserId(),chartRequest.getYear(),chartRequest.getMonth(),i,chartRequest.getType(),chartRequest.getCategoryId()));
            }
        }
        barChartResponse.setLabels(labels);
        barChartResponse.setAmount(amount);
        return barChartResponse;
    }

    private void addItem(List<Integer> arr, Integer value){
        if (value == null) {
            arr.add(0);
        } else arr.add(value);
    }
    
    public PieChartResponse pie(ChartRequest chartRequest){
        PieChartResponse pieChartResponse = new PieChartResponse();
        Integer num;
        List<String> label = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        List<Category> categories = categoryRepository.GetUserCategory(chartRequest.getUserId(),chartRequest.getType());
        for (Category cat:
                categories) {
            if (chartRequest.getIn().equals("year")){
                num = transactionRepository.getSumTransactionOfYearByTypeAndCategory(chartRequest.getUserId(),chartRequest.getYear(),chartRequest.getType(),cat.getId());
            } else num = transactionRepository.getSumTransactionOfMonthByTypeAndCategory(chartRequest.getUserId(),chartRequest.getYear(),chartRequest.getMonth(),chartRequest.getType(),cat.getId());
            if (num!=null) {
                label.add(cat.getName());
                data.add(num);
            }
        }
        pieChartResponse.setLabels(label);
        pieChartResponse.setData(data);
        return pieChartResponse;
    }
}
