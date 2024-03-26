package com.eva.Employee_Management_System.controller;

import com.eva.Employee_Management_System.entity.Attendance;
import com.eva.Employee_Management_System.entity.Leave;
import com.eva.Employee_Management_System.service.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@AllArgsConstructor
@Controller
public class LeaveController {
    private LeaveService leaveService;

    @GetMapping("/leave")
    public String listAllLeave(Model model){
        List<Leave> leave = leaveService.getAllLeave();
        model.addAttribute("leave", leave); // Correct attribute name
        return "leave"; // Return the Thymeleaf template for leave
    }


    @GetMapping("/leave/form")
    public String showLeaveForm(Model model) {
        model.addAttribute("leave", new Leave());
        return "leave_form"; // Return the Thymeleaf template for the leave form
    }

    @PostMapping("/leave/form")
    public String saveLeave(@ModelAttribute("leave") Leave leave) {
        leaveService.addLeave(leave);
        return "leaveSuccess"; // Redirect to the leave dashboard
    }

    @GetMapping("/view-leave")
    public String viewLeave(Model model) {
        List<Leave> leaveList = leaveService.getAllLeave();
        model.addAttribute("leaveList", leaveList);
        return "redirect:/employees"; // Thymeleaf template for viewing attendance
    }
}
