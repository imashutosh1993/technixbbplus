package com.technix.bbplus.controller;
import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.User;
import com.technix.bbplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers(@RequestParam int pageNo,@RequestParam int pageSize) {
        try {
            PageResponse<User> users = userService.getAllUsers(pageNo,pageSize);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/updateBy/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        try {
            boolean deleted = userService.deleteUser(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
@GetMapping("/customer/{customerId}")
    public ResponseEntity<?>getBycustomerId(int CustomerId){
        return new ResponseEntity<>(userService.getBycustomerId(CustomerId),HttpStatus.OK);
    }
}
