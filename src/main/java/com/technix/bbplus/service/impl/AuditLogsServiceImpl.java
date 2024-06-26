package com.technix.bbplus.service.impl;
import com.technix.bbplus.entity.AuditLogs;
import com.technix.bbplus.repository.AuditLogsRepository;
import com.technix.bbplus.service.AuditLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditLogsServiceImpl implements AuditLogsService {
    @Autowired
    private AuditLogsRepository auditLogsRepository;


    @Override
    public List<AuditLogs> getByuserid(int userId) {
        return auditLogsRepository.findByUserId(userId);
    }
}
