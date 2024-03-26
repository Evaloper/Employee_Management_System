package com.eva.Employee_Management_System.service;

import com.eva.Employee_Management_System.entity.Attendance;
import com.eva.Employee_Management_System.entity.Leave;

import java.util.List;

public interface LeaveService {
    void addLeave(Leave leave);
    List<Leave> getAllLeave();
}
