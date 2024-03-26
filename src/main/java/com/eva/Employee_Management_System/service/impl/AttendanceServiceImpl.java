package com.eva.Employee_Management_System.service.impl;

import com.eva.Employee_Management_System.entity.Attendance;
import com.eva.Employee_Management_System.entity.Employee;
import com.eva.Employee_Management_System.repository.AttendanceRepository;
import com.eva.Employee_Management_System.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

//    @Override
//    public Attendance getAttendanceById(Long id) {
//        return null;
//    }

}
