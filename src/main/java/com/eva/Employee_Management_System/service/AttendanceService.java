package com.eva.Employee_Management_System.service;

import com.eva.Employee_Management_System.entity.Attendance;
import com.eva.Employee_Management_System.entity.Employee;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendance();
    Attendance addAttendance(Attendance attendance);

//    Attendance getAttendanceById(Long id);
}
