package com.employee.management.demo.service;

import com.employee.management.demo.dto.EmployeeDto;
import com.employee.management.demo.mapper.EmployeeMapper;
import com.employee.management.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setFirstname("Mennatallah");
        employeeDto.setLastname("Yahia");
        employeeDto.setEmail("mennatallah.yahia@example.com");
        employeeDto.setDepartment("Engineering");
        employeeDto.setSalary(150000.0);
    }

    @Test
    void testCreateEmployee() {
       EmployeeDto createdEmp = employeeService.createEmployee(employeeDto);
    }

    @Test
    void testRetrieveEmployeeById() {
    }

    @Test
    void testRetrieveAllEmployees() {
    }

    @Test
    void testModifyEmployeeById() {
    }

    @Test
    void testRemoveEmployeeById() {
    }
}
