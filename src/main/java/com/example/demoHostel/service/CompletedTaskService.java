package com.example.demoHostel.service;

import com.example.demoHostel.model.CompletedTask;
import com.example.demoHostel.repo.completedTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedTaskService {

    @Autowired
    completedTaskRepo repo;


    public void save(CompletedTask completedTask) {
        repo.save(completedTask);
    }

    public List<CompletedTask> getAllTask() {
        return repo.findAll();

    }
}
