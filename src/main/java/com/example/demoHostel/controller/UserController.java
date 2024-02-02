package com.example.demoHostel.controller;

import com.example.demoHostel.model.TaskData;
import com.example.demoHostel.model.UserDto;
import com.example.demoHostel.model.user;
import com.example.demoHostel.repo.UserRepo;
import com.example.demoHostel.service.TaskService;
import com.example.demoHostel.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
@Autowired
 private UserService userService;
 @Autowired
 TaskService taskService;





            @GetMapping("/userData")
           public ResponseEntity<List<TaskData>> getUserTask(Authentication authentication){
                String username=authentication.getName();
                List<TaskData> td=taskService.getTaskUser(username);
                return ResponseEntity.ok(td);

                }

                    @PostMapping("/addTask")
              public ResponseEntity<TaskData> createTask(Authentication auth, @RequestBody TaskData td){
                    String username= auth.getName();
                    TaskData taskData=taskService.createTask(username,td);
                    return  ResponseEntity.ok(taskData);
                }


    @GetMapping("/login")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Login page accessed successfully!");

    }




    @PostMapping("/register/save")
    public ResponseEntity<String> registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        user existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return ResponseEntity.badRequest().body("Validation error: There are validation errors in the submitted form.");

        }

        userService.saveUser(userDto);
        return ResponseEntity.ok("Registration successful!");

    }
}
