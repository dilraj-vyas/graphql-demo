package com.graphql.demo.service;

import com.graphql.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(Integer empId);

    public Employee save(Employee employee);


}
