package com.employee_service.employee_service.service.impl;

import com.employee_service.employee_service.dto.APIResponseDto;
import com.employee_service.employee_service.dto.DepartmentDto;
import com.employee_service.employee_service.dto.EmployeeDto;
import com.employee_service.employee_service.entity.Employee;
import com.employee_service.employee_service.repository.EmployeeRepository;
import com.employee_service.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    /* private RestTemplate restTemplate;*/
    //  private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // convert employeeDto to employeeJPA entity
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee  saveEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto1 = new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
        return employeeDto1;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee =employeeRepository.findById(employeeId).get();

      /* ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),DepartmentDto.class);
       DepartmentDto departmentDto = responseEntity.getBody();*/

      /*  DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode(),DepartmentDto.class)
                .retrieve().bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }

}
