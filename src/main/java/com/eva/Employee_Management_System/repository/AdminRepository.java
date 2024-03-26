package com.eva.Employee_Management_System.repository;

import com.eva.Employee_Management_System.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
