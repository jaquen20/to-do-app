package com.example.demoHostel.controller;

import com.example.demoHostel.model.CompletedTask;
import com.example.demoHostel.model.TaskData;
import com.example.demoHostel.service.CompletedTaskService;
import com.example.demoHostel.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    CompletedTaskService service;

    @GetMapping("/completedTask")
    public ResponseEntity<List<CompletedTask>> getCompletedTask(){
        List<CompletedTask>ct=service.getAllTask();
        return ResponseEntity.ok( ct);
    }
    @PostMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateToDoStatus(@PathVariable Long id) {
        if (taskService.updateStatus(id)) {
            //service.CompletedTask();
            return ResponseEntity.ok("Update Success");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update Failure");
    }


    @PostMapping("/CreateTask")
    public ResponseEntity<TaskData> getTask(@RequestBody TaskData data) {
        TaskData newData = taskService.saveData(data);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<TaskData>> getDataById(@PathVariable Long id){
        Optional<TaskData> taskData=taskService.getDataById(id);
        return  ResponseEntity.ok(taskData);
    }

    @GetMapping("/home")
    public ResponseEntity<List<TaskData>> getAllData() throws IOException {
        List<TaskData> td = taskService.getAllTask();
        return ResponseEntity.ok(td);
    }



    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskData data) {
        Optional<TaskData> td = taskService.findById(id);
        if (td.isPresent()) {
            TaskData taskToUpdate = td.get();

            taskToUpdate.setDue_Date(data.getDue_Date());
            taskToUpdate.setTitle(data.getTitle());
            taskToUpdate.setDescription(data.getDescription());
            taskToUpdate.setCompleted(data.getCompleted());


            if (taskService.saveOrUpdateToDoItem(taskToUpdate)) {
                return ResponseEntity.ok("Edit Success");
            }
//            TaskData updatedTask = taskService.saveData(taskToUpdate);
//
//            return ResponseEntity.ok(updatedTask);
//        } else {
//            return ResponseEntity.notFound().build();
//        }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Edit Failure");

    }

//    @GetMapping("/delete/{id}")
//    public String deleteTask(@PathVariable Long id) {
//        taskService.deleteTask(id);
//        return "deleted";
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteToDoItem(@PathVariable Long id) {
        if (taskService.deleteToDoItem(id)) {
            return ResponseEntity.ok("Delete Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("delete failed");
    }


}
