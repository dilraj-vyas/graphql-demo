package com.graphql.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private int id;

    private String name;
    private String email;
    private String designation;


}
