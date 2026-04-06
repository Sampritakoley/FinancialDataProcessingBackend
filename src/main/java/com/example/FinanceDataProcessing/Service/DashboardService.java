package com.example.FinanceDataProcessing.Service;

import com.example.FinanceDataProcessing.Dao.FinancialRecord;
import com.example.FinanceDataProcessing.Repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repository;

    public Map<String,Double> getSummary(){

        List<FinancialRecord> records = repository.findAll();

        double income = records.stream()
                .filter(r -> r.getType().equals("income"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType().equals("expense"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Map<String,Double> result = new HashMap<>();

        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netBalance", income-expense);

        return result;
    }
}