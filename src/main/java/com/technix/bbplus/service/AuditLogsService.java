package com.technix.bbplus.service;


import com.technix.bbplus.entity.AuditLogs;



import java.util.List;

public interface AuditLogsService {

    List<AuditLogs> getByuserid(int userId);

}
