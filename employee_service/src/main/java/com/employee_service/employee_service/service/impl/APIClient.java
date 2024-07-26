package com.employee_service.employee_service.service.impl;

import com.employee_service.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface APIClient {


    @GetMapping("api/department/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
    }
