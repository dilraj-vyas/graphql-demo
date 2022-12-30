package com.graphql.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.model.EmployeeRequest;
import com.graphql.demo.model.EmployeeResponse;
import com.graphql.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @QueryMapping("getEmployee")
    public Employee getEmployee(@Argument Integer empId) {
        return employeeService.getEmployee(empId);
    }

    @QueryMapping("allEmployee")
    public EmployeeResponse getAllEmployee(@Argument int pageNo, @Argument int pageSize, @Argument String sortBy, @Argument String sortDir) {
        return employeeService.getAllEmployee(pageNo, pageSize, sortBy, sortDir);
    }


    @MutationMapping("createEmployee")
    public Employee create(@Argument EmployeeRequest employeeRequest) {
        Employee employee =
            Employee.builder().name(employeeRequest.getName()).email(employeeRequest.getName()).designation(employeeRequest.getDesignation()).build();
        return employeeService.save(employee);
    }

}
