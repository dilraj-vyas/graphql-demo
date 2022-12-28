package com.graphql.demo.controller;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.model.EmployeeRequest;
import com.graphql.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @QueryMapping("getEmployee")
    public Employee getEmployee(@Argument Integer empId) {
        return employeeService.getEmployee(empId);
    }

    @QueryMapping("allEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @MutationMapping("createEmployee")
    public Employee create(@Argument EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder().name(employeeRequest.getName()).email(employeeRequest.getName()).designation(employeeRequest.getDesignation()).build();
        return employeeService.save(employee);
    }

}
