package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.UserLogRecord;
import com.technix.bbplus.repository.UserLogRecordRepository;
import com.technix.bbplus.service.UserLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLogRecordServiceImpl implements UserLogRecordService {

        @Autowired
        private UserLogRecordRepository userLogRecordRepository;

        @Override
        public List<UserLogRecord> getAllUserLogRecords() {
            return userLogRecordRepository.findAll();
        }

        @Override
        public Optional<UserLogRecord> getUserLogRecordById(int id) {
            return userLogRecordRepository.findById(id);
        }

        @Override
        public UserLogRecord createUserLogRecord(UserLogRecord userLogRecord) {
            return userLogRecordRepository.save(userLogRecord);
        }

        @Override
        public UserLogRecord updateUserLogRecord(int id, UserLogRecord userLogRecord) {
            return userLogRecordRepository.findById(id).map(existingUserLogRecord -> {
                if (userLogRecord.getBrowser() != null) existingUserLogRecord.setBrowser(userLogRecord.getBrowser());
                if (userLogRecord.getPlatform() != null) existingUserLogRecord.setPlatform(userLogRecord.getPlatform());
                if (userLogRecord.getIpAdress() != null) existingUserLogRecord.setIpAdress(userLogRecord.getIpAdress());
                if (userLogRecord.getCity() != null) existingUserLogRecord.setCity(userLogRecord.getCity());
                if (userLogRecord.getRegion() != null) existingUserLogRecord.setRegion(userLogRecord.getRegion());
                if (userLogRecord.getCountry() != null) existingUserLogRecord.setCountry(userLogRecord.getCountry());
                if (userLogRecord.getPostal() != null) existingUserLogRecord.setPostal(userLogRecord.getPostal());
                if (userLogRecord.getLocation() != null) existingUserLogRecord.setLocation(userLogRecord.getLocation());
                if (userLogRecord.getIsp() != null) existingUserLogRecord.setIsp(userLogRecord.getIsp());
                if (userLogRecord.getLoginAt() != null) existingUserLogRecord.setLoginAt(userLogRecord.getLoginAt());
                return userLogRecordRepository.save(existingUserLogRecord);
            }).orElseThrow(() -> new RuntimeException("UserLogRecord not found with id " + id));
        }

        @Override
        public void deleteUserLogRecord(int id) {

            userLogRecordRepository.deleteById(id);
        }

}
