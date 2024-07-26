package com.department_service.department_service.controller;

import com.department_service.department_service.dto.DepartmentDto;
import com.department_service.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/department")
@Slf4j
public class DepartmentController {
    DepartmentService  departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto department) {
        DepartmentDto save = departmentService.saveDepartment(department);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    // Build getDepartment REST API

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto= departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
