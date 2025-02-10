package com.employee.management.demo.mapper;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.dto.EmployeeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeMapperTest {

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @Test
    void testToEmployee() {
        // arrange
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstname("Mennatallah");
        employeeDto.setLastname("Yahia");
        employeeDto.setSalary(170000d);
        employeeDto.setDepartment("Software Engineering");
        employeeDto.setEmail("mennatallah.yahia.ali@gmail.com");
        // act
        Employee employee = employeeMapper.toEmployee(employeeDto);
        // assert
        assertThat(employee.getFirstname()).isEqualTo(employeeDto.getFirstname());
        assertThat(employee.getLastname()).isEqualTo(employeeDto.getLastname());
        assertThat(employee.getDepartment()).isEqualTo(employeeDto.getDepartment());
        assertThat(employee.getEmail()).isEqualTo(employeeDto.getEmail());
        assertThat(employee.getSalary()).isEqualTo(employeeDto.getSalary());
    }

    @Test
    void testToEmployeeDto() {
        // arrange
        Employee employee = new Employee();
        employee.setFirstname("Mennatallah");
        employee.setLastname("Yahia");
        employee.setSalary(170000d);
        employee.setDepartment("Software Engineering");
        employee.setEmail("mennatallah.yahia.ali@gmail.com");
        employee.setId(1);
        // act
        EmployeeDto employeeDto = employeeMapper.toEmployeeDto(employee);
        // assert
        assertThat(employeeDto.getFirstname()).isEqualTo(employee.getFirstname());
        assertThat(employeeDto.getLastname()).isEqualTo(employee.getLastname());
        assertThat(employeeDto.getDepartment()).isEqualTo(employee.getDepartment());
        assertThat(employeeDto.getEmail()).isEqualTo(employee.getEmail());
        assertThat(employeeDto.getSalary()).isEqualTo(employee.getSalary());
        Assertions.assertEquals(employeeDto.getId(), employee.getId());
    }

    @Test
    void testToEmployeeWithId() {
        // arrange
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstname("Mennatallah");
        employeeDto.setLastname("Yahia");
        employeeDto.setSalary(170000d);
        employeeDto.setDepartment("Software Engineering");
        employeeDto.setEmail("mennatallah.yahia.ali@gmail.com");
        // act
        Employee employee = employeeMapper.toEmployee(employeeDto,1);
        // assert
        assertThat(employee.getFirstname()).isEqualTo(employeeDto.getFirstname());
        assertThat(employee.getLastname()).isEqualTo(employeeDto.getLastname());
        assertThat(employee.getDepartment()).isEqualTo(employeeDto.getDepartment());
        assertThat(employee.getEmail()).isEqualTo(employeeDto.getEmail());
        assertThat(employee.getSalary()).isEqualTo(employeeDto.getSalary());
        assertThat(employee.getId()).isEqualTo(1);
    }

}
