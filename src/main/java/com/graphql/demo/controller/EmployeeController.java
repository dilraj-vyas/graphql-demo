package com.graphql.demo.controller;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @QueryMapping("getEmployee")
    public Employee getEmployee(@Argument Integer id) {
        return employeeService.getEmployee(id);
    }

    @QueryMapping("allEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

}
