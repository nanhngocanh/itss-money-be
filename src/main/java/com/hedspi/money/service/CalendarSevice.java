package com.hedspi.money.service;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.repository.TransactionRepository;
import com.hedspi.money.request.CalendarRequest;
import com.hedspi.money.response.CalendarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarSevice {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<CalendarResponse> calendar(CalendarRequest calendarRequest){
        List<CalendarResponse> calendarResponse = new ArrayList<>();
        Integer thu;
        Integer chi;
        Integer daysInMonth = YearMonth.of(calendarRequest.getYear(), calendarRequest.getMonth()).lengthOfMonth();
        System.out.println(daysInMonth);
        for (int i = 1; i <= daysInMonth ; i++) {
            thu = transactionRepository.getSumTransactionOfDayByType(
                    calendarRequest.getUserId(),
                    calendarRequest.getYear(),
                    calendarRequest.getMonth(),
                    i,
                    1);
            if (thu == null)thu = 0;
            chi = transactionRepository.getSumTransactionOfDayByType(
                    calendarRequest.getUserId(),
                    calendarRequest.getYear(),
                    calendarRequest.getMonth(),
                    i,
                    -1);
            if (chi == null) chi = 0;
            calendarResponse.add(new CalendarResponse(
                    i,
                    thu,
                    chi
                    )
            );
        }
        return calendarResponse;
    }
}
