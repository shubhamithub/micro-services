package com.department_service.department_service.repository;

import com.department_service.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);


}
