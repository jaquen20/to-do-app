package com.example.demoHostel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data @Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskData {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Description;
    private String Title;
    private Date Due_Date;
    private Boolean Completed;

    @ManyToOne
    @JoinColumn(name="userid")
    private user user;
}
