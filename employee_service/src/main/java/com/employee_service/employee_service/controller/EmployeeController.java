package com.employee_service.employee_service.controller;

import com.employee_service.employee_service.dto.APIResponseDto;
import com.employee_service.employee_service.dto.EmployeeDto;
import com.employee_service.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee =  employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
    APIResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
    return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
