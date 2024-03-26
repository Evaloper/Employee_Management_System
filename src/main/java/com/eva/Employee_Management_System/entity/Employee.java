package com.eva.Employee_Management_System.entity;


import com.eva.Employee_Management_System.enums.DepartmentName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employee_table")
public class Employee extends BaseClass {

    private Long employeeId;

    @Size(min = 6, max = 8, message = "Token must be at least 6 and at most 8")
    @NotBlank(message = "Token must not be blank")
    private String token;

    @Enumerated(EnumType.STRING)
    private DepartmentName department;

    private Double salary;
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<Attendance> attendanceList;
//
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<Leave> leaveList;








//    @ManyToOne
//    @JoinColumn(name = "admin_id") // Adjust column name as needed
//    private Admin admin;



//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<Attendance> attendanceList;
//
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    private List<Leave> leaveList;

}
