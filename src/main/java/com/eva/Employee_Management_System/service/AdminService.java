package com.eva.Employee_Management_System.service;

import com.eva.Employee_Management_System.entity.Admin;

public interface AdminService {
    Admin getAdminByEmail(String email);
    void addAdmin(Admin admin);
}
