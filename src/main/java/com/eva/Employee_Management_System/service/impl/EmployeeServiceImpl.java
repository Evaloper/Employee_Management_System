package com.eva.Employee_Management_System.service.impl;

import com.eva.Employee_Management_System.entity.Employee;
import com.eva.Employee_Management_System.repository.EmployeeRepository;
import com.eva.Employee_Management_System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee getEmployeeByIdWithEmployeePara(Employee id) {
        return employeeRepository.findById(id.getId()).get();
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployeesBasicInfo() {
        // Fetch all employees from the repository
        List<Employee> employees = employeeRepository.findAll();

        // Iterate through the list of employees and remove salary and token fields
        for (Employee employee : employees) {
            employee.setSalary(null); // Exclude salary
            employee.setToken(null);  // Exclude token
        }

        return employees;
    }

}
