package com.example.hibernatejpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "employee_city")),
            @AttributeOverride(name = "state", column = @Column(name = "employee_state")),
            @AttributeOverride(name = "country", column = @Column(name = "employee_country"))
    })
    private Address employeeAddress;

    @ManyToMany(mappedBy = "employeeList")
    private List<Project> projectList;

}
