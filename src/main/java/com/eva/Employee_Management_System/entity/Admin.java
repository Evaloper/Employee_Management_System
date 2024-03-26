package com.eva.Employee_Management_System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "admin_tbl")
public class Admin extends BaseClass{
//    @OneToMany
//    List<Employee> employees;

    private String password;

}
