package com.graphql.demo.service;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.model.EmployeeResponse;

public interface EmployeeService {

    public EmployeeResponse getAllEmployee(int pageNo, int pageSize, String sortBy, String sortDir);

    public Employee getEmployee(Integer empId);

    public Employee save(Employee employee);


}
