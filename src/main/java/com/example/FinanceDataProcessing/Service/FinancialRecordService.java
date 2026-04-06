package com.example.FinanceDataProcessing.Service;

import com.example.FinanceDataProcessing.Dao.FinancialRecord;
import com.example.FinanceDataProcessing.Repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository recordRepository;

    public FinancialRecord createRecord(FinancialRecord record){
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords(){
        return recordRepository.findAll();
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated){

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow();

        record.setAmount(updated.getAmount());
        record.setCategory(updated.getCategory());
        record.setType(updated.getType());

        return recordRepository.save(record);
    }

    public void deleteRecord(Long id){
        recordRepository.deleteById(id);
    }
}