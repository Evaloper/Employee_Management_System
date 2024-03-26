package com.eva.Employee_Management_System.service.impl;

import com.eva.Employee_Management_System.entity.Admin;
import com.eva.Employee_Management_System.repository.AdminRepository;
import com.eva.Employee_Management_System.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
