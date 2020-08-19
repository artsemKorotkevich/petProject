package by.innowise.by.innowise.petProject.controllers;

import by.innowise.by.innowise.petProject.entities.User;
import by.innowise.by.innowise.petProject.services.UserService;
import by.innowise.by.innowise.petProject.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping("/user")
    public ResponseEntity<User> getUserById(@RequestParam("userId") UUID userId){
        return ResponseEntity.ok().body(service.findById(userId));
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody  User user) {
      return ResponseEntity.ok().body(service.save(user));
    }

    @DeleteMapping("/user")
    public ResponseEntity deleteUser(@RequestParam("userId") UUID userId){
        service.delete(userId);
        return ResponseEntity.ok().body("ok");
    }
    @PutMapping("/user")
    public ResponseEntity updateUser(@RequestBody User user, @RequestParam("id") UUID id){
        return ResponseEntity.ok().body(service.update(user,id));
    }
}
