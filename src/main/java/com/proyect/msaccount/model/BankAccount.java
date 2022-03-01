package com.proyect.msaccount.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@Document(collection = "Account")
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    private String id;

    private Customer customer;

    private String accountNumber;

    private Double balance;

    private Double amount;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    private Integer movements;

    private String idClient;

}
