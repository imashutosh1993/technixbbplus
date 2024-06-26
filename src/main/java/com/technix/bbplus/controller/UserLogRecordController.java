package com.technix.bbplus.controller;
import com.technix.bbplus.entity.UserLogRecord;
import com.technix.bbplus.service.UserLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userlogrecord")
public class UserLogRecordController {

    @Autowired
    private UserLogRecordService userLogRecordService;

    @GetMapping("/get")
    public List<UserLogRecord> getAllUserLogRecords() {
        return userLogRecordService.getAllUserLogRecords();
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<UserLogRecord> getUserLogRecordById(@PathVariable int id) {
        return userLogRecordService.getUserLogRecordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public UserLogRecord createUserLogRecord(@RequestBody UserLogRecord userLogRecord) {
        return userLogRecordService.createUserLogRecord(userLogRecord);
    }

    @PutMapping("/updateby/{id}")
    public ResponseEntity<UserLogRecord> updateUserLogRecord(@PathVariable int id, @RequestBody UserLogRecord userLogRecord) {
        try {
            UserLogRecord updatedUserLogRecord = userLogRecordService.updateUserLogRecord(id, userLogRecord);
            return ResponseEntity.ok(updatedUserLogRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<Void> deleteUserLogRecord(@PathVariable int id) {
        userLogRecordService.deleteUserLogRecord(id);
        return ResponseEntity.noContent().build();
    }

}
