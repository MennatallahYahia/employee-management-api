package com.employee.management.demo.it;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EmployeeControllerIT {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testSaveEmployee() {
        // arrange act
        Employee savedEmployee = createEmployee();
        // assert
        assertThat(savedEmployee.getId()).isNotNull();
        assertThat(savedEmployee.getFirstname()).isEqualTo("Mennatallah");
        assertThat(savedEmployee.getId()).isEqualTo(1);
    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("Mennatallah");
        employee.setLastname("Yahia");
        employee.setEmail("mennatallah.yahia@example.com");
        employee.setDepartment("Engineering");
        employee.setSalary(60000.0);
        return employeeRepository.save(employee);
    }

    @Test
    void testRetrieveEmployee() {
        // arrange
        Employee employee = createEmployee();
        // act
        Optional<Employee> savedEmployee = employeeRepository.findById(employee.getId());
        // assert
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.isPresent()).isTrue();
        assertThat(savedEmployee.get().getEmail()).isEqualTo("mennatallah.yahia@example.com");
        assertThat(savedEmployee.get().getId()).isEqualTo(employee.getId());
    }
}
