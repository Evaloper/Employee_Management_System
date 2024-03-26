package com.eva.Employee_Management_System.repository;

import com.eva.Employee_Management_System.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    //List<Attendance> findAll();
}
