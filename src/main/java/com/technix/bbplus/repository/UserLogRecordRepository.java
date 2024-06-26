package com.technix.bbplus.repository;

import com.technix.bbplus.entity.UserLogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRecordRepository extends JpaRepository<UserLogRecord,Integer> {
}
