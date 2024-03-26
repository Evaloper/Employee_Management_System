package com.eva.Employee_Management_System.controller;

import com.eva.Employee_Management_System.entity.Attendance;
import com.eva.Employee_Management_System.entity.Employee;
import com.eva.Employee_Management_System.service.AttendanceService;
import com.eva.Employee_Management_System.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
public class AttendanceController {
    private  AttendanceService attendanceService;
    private EmployeeService employeeService;
    @GetMapping("/attendance")
    public String listAllAttendance(Model model){
        model.addAttribute("attendance", attendanceService.getAllAttendance());
        return "attendance";
    }

    @GetMapping("/attendance/form")
    public String showAttendanceForm(Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        return "attendance_form"; // Return the Thymeleaf template for the attendance form
    }

//    @PostMapping("/employees/attendance")
//    public String addAttendance(Model model) {
//        Attendance attendance = new Attendance();
//        model.addAttribute("attendance", attendance);
//        attendanceService.addAttendance(attendance);
//        return "attendance_form"; // Redirect to dashboard or wherever appropriate
//    }



//    @PostMapping("/attendance/form")
//    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
//        attendanceService.addAttendance(attendance);
//        return "welcome";
//    }

    @PostMapping("/attendance/form")
    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
        // Check if the employee exists
        if (attendance.getEmployeeId() == null || attendance.getEmployeeId().getId() == null) {
            // Handle the case where the employee is not provided or does not exist
            return "attendanceerror"; // Redirect to an error page or appropriate action
        }

        // Retrieve the employee from the database using the provided employeeId
        Long employeeId = attendance.getEmployeeId().getId();
        Employee employee = employeeService.getEmployeeById(employeeId);

        // Check if the employee exists
        if (employee == null) {
            // Handle the case where the employee does not exist
            return "attendanceerror"; // Redirect to an error page or appropriate action
        }

        // Save the attendance
        attendanceService.addAttendance(attendance);

        // Redirect to the appropriate page after successful submission
        return "welcome";
    }





    @GetMapping("/view-attendance")
    public String viewAttendance(Model model) {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        model.addAttribute("attendanceList", attendanceList);
        return "redirect:/employees"; // Thymeleaf template for viewing attendance
    }
}
