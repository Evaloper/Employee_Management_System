package com.eva.Employee_Management_System.controller;

import com.eva.Employee_Management_System.entity.Employee;
import com.eva.Employee_Management_System.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@AllArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
//    @GetMapping
//    public String showLoginPage() {
//        return "login"; // Return the Thymeleaf template for the login page
//    }
//
//    @PostMapping
//    public String processLogin() {
//        // No authentication logic needed, directly redirect to the employees/basic page
//        return "redirect:/employees/basic";
//    }
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showLoginPage() {
        return "login"; // Return the Thymeleaf template for the login page
    }

    @PostMapping
    public String processLogin(@RequestParam String email, @RequestParam String token) {
        // Retrieve employee by email
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee != null && employee.getToken().equals(token)) {
            // Authentication successful, redirect to the desired page
            return "redirect:/employees/basic"; // Redirect to the employees page after successful login
        } else {
            // Authentication failed, redirect back to the login form with an error message
            return "redirect:/login?error";
        }
    }
}
