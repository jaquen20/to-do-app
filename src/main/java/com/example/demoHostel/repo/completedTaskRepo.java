package com.example.demoHostel.repo;

import com.example.demoHostel.model.CompletedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface completedTaskRepo extends JpaRepository<CompletedTask,Long> {
}
