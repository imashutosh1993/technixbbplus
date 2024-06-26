package com.technix.bbplus.repository;
import com.technix.bbplus.entity.AuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuditLogsRepository extends JpaRepository<AuditLogs,Integer> {

    List<AuditLogs> findByUserId(int userId);

}
