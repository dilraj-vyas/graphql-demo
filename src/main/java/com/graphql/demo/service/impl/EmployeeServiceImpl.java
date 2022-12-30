package com.graphql.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.graphql.demo.dto.EmployeeDto;
import com.graphql.demo.entity.Employee;
import com.graphql.demo.model.EmployeeResponse;
import com.graphql.demo.repository.EmployeeRepository;
import com.graphql.demo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse getAllEmployee(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Employee> employees = employeeRepository.findAll(pageable);

        List<EmployeeDto> employeeDtos = employees.getContent().stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());
        EmployeeResponse employeeResponse =
            EmployeeResponse.builder().content(employeeDtos).pageNo(employees.getNumber()).pageSize(employees.getSize())
                .totalElements(employees.getTotalElements()).totalPages(employees.getTotalPages()).build();
        return employeeResponse;
    }


    private EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto =
            EmployeeDto.builder().email(employee.getEmail()).name(employee.getName()).designation(employee.getDesignation()).id(employee.getId())
                .build();

        return employeeDto;
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
