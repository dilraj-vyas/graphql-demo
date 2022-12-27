package com.graphql.demo;

import com.graphql.demo.entity.Employee;
import com.graphql.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee(1, "Ankit", "ankit@gmail.com", "Software Engineer");
        Employee employee1 = new Employee(2, "Sourabh", "sourabh@gmail.com", "System Engineer");
        employeeService.save(employee);
        employeeService.save(employee1);
    }
}
