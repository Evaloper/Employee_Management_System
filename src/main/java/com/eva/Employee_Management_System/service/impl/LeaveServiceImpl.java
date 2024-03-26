package com.eva.Employee_Management_System.service.impl;

import com.eva.Employee_Management_System.entity.Leave;
import com.eva.Employee_Management_System.repository.LeaveRepository;
import com.eva.Employee_Management_System.service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;
    @Override
    public void addLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }
}
