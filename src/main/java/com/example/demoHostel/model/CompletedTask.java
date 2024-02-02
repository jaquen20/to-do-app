package com.example.demoHostel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data @Entity
public class CompletedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String title;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date due_Date;
    private Boolean Completed;
}

