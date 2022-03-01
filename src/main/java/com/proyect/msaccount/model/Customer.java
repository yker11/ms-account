package com.proyect.msaccount.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Customer {

    private String id;

    private String name;

    private String lastName;

    private DocumentType documentType;

    private String documentNumber;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateBirth;

    private String gender;

    public enum DocumentType {
        DNI,
        CEX,
        PASSPORT
    }
}
