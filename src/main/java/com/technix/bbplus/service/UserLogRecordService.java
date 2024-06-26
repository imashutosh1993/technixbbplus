package com.technix.bbplus.service;

import com.technix.bbplus.entity.Subscription;
import com.technix.bbplus.entity.UserLogRecord;

import java.util.List;
import java.util.Optional;

public interface UserLogRecordService  {

    List<UserLogRecord> getAllUserLogRecords();
    Optional<UserLogRecord> getUserLogRecordById(int id);
    UserLogRecord createUserLogRecord(UserLogRecord userLogRecord);
    UserLogRecord updateUserLogRecord(int id, UserLogRecord userLogRecord);
    void deleteUserLogRecord(int id);

}
