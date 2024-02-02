package com.example.demoHostel.repo;

import com.example.demoHostel.model.TaskData;
import com.example.demoHostel.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskData,Long> {


   // List<TaskData> findByUserOrderByDueDateAsc(user user);
    List<TaskData> findByUser(user user);
}
