package com.example.FinanceDataProcessing.Dao;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String type; // income / expense

    private String category;

    private LocalDate date;

    private String notes;

    @ManyToOne
    private User createdBy;
}