package com.eva.Employee_Management_System.controller;

import com.eva.Employee_Management_System.entity.Employee;
import com.eva.Employee_Management_System.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public String listAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

//    @PostMapping("/employees")
//    public String saveEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
//        if (result.hasErrors()) {
//            return "create_employee"; // Return to the form page if there are validation errors
//        }
//
//        // Parse the mobile number from String to Integer
//        String mobileNoAsString = String.valueOf(employee.getMobileNo());
//        if (mobileNoAsString != null && !mobileNoAsString.isEmpty()) {
//            try {
//                Integer mobileNo = Integer.parseInt(mobileNoAsString);
//                employee.setMobileNo(Long.valueOf(mobileNo));
//            } catch (NumberFormatException e) {
//                // Handle parsing error (e.g., log error or display error message)
//            }
//        }
//
//        // Save the employee and redirect to the appropriate page
//        employeeService.addEmployee(employee);
//        return "redirect:/employees"; // Redirect to the list of employees page
//    }


    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";

    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setMobileNo(employee.getMobileNo());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setToken(employee.getToken());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }

    @GetMapping("/employees/basic")
    public String getAllEmployeesBasic(Model model) {
        List<Employee> employees = employeeService.getAllEmployeesBasicInfo();
        model.addAttribute("employees", employees);
        return "employees_basics"; // Return the view name for displaying the basic employee list
    }

}
