package com.example.FinanceDataProcessing.Repository;

import com.example.FinanceDataProcessing.Dao.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord,Long> {

    List<FinancialRecord> findByType(String type);

}