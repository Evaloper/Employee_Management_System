package com.eva.Employee_Management_System.service;

import com.eva.Employee_Management_System.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee getEmployeeByEmail(String email);
    Employee getEmployeeByIdWithEmployeePara(Employee id);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    public List<Employee> getAllEmployeesBasicInfo();

}
