package com.graphql.demo.service.impl;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.repository.EmployeeRepository;
import com.graphql.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
