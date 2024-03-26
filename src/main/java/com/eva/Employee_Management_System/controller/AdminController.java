package com.eva.Employee_Management_System.controller;

import com.eva.Employee_Management_System.entity.Admin;
import com.eva.Employee_Management_System.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/adminLogin")
public class AdminController {

//    @GetMapping
//    public String showLoginForm() {
//        return "adminLogin"; // Return the Thymeleaf template for the admin login form
//    }
//
//    @PostMapping
//    public String processLogin() {
//        // Perform authentication logic if needed
//        // For simplicity, let's assume the login is successful
//        return "redirect:/employees"; // Redirect to the employees page after login
//    }

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String showLoginForm() {
        return "adminLogin"; // Return the Thymeleaf template for the admin login form
    }

    @PostMapping
    public String processLogin(@RequestParam String email, @RequestParam String password) {
        // Fetch admin details from the database based on the provided username
        Admin admin = adminService.getAdminByEmail(email);

        // Check if admin exists and the password matches
        if (admin != null && admin.getPassword().equals(password)) {
            // Authentication successful, redirect to the employees page
            return "redirect:/employees";
        } else {
            // Authentication failed, redirect back to the login page with an error message
            return "redirect:/admin/login?error";
        }
    }
}
