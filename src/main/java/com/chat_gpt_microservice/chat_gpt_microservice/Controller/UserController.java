package com.chat_gpt_microservice.chat_gpt_microservice.Controller;

import com.chat_gpt_microservice.chat_gpt_microservice.Model.UserDto;
import com.chat_gpt_microservice.chat_gpt_microservice.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long userId){
        UserDto userResult = service.getUserById(userId);
        return new ResponseEntity<>(userResult, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        var userResult  = service.getAllUsers();
        return new ResponseEntity<>(userResult,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto UserDto){
        UserDto userResult = service.createUser(UserDto);
        return new ResponseEntity<>(userResult,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto UserDto,
                                              @PathVariable(name = "id") Long userId){
        UserDto userResult = service.updateUser(UserDto,userId);
        return new ResponseEntity<>(userResult,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser( @PathVariable(name = "id") Long userId){
        service.deleteUser(userId);
        return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }
}
