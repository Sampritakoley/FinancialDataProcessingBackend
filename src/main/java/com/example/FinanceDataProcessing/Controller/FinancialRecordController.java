package com.example.FinanceDataProcessing.Controller;

import com.example.FinanceDataProcessing.Dao.FinancialRecord;
import com.example.FinanceDataProcessing.Service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FinancialRecord record){
        return ResponseEntity.ok(service.createRecord(record));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAllRecords());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody FinancialRecord record){
        return ResponseEntity.ok(service.updateRecord(id,record));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteRecord(id);
        return ResponseEntity.ok("Deleted");
    }
}