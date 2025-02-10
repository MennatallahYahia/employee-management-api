package com.employee.management.demo.controller;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.dto.EmployeeDto;
import com.employee.management.demo.service.EmailValidationService;
import com.employee.management.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;

    @MockitoBean
    private EmailValidationService emailValidationService;

    private EmployeeDto employeeDto;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setFirstname("Mennatallah");
        employeeDto.setLastname("Yahia");
        employeeDto.setEmail("mennatallah.yahia@example.com");
        employeeDto.setDepartment("Engineering");
        employeeDto.setSalary(150000.0);

        employee = new Employee();
        employee.setId(1L);
        employee.setFirstname("Mennatallah");
        employee.setLastname("Yahia");
        employee.setEmail("mennatallah.yahia@example.com");
        employee.setDepartment("Engineering");
        employee.setSalary(150000.0);
    }

    @Test
    void testCreateValidEmployee() throws Exception {
        Mockito.when(employeeService.createEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);
        Mockito.when(emailValidationService.isValidEmail(any(String.class))).thenReturn(true);

        mockMvc.perform(post("/api/employees/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employeeDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname").value("Mennatallah"))
                .andExpect(jsonPath("$.email").value("mennatallah.yahia@example.com"));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        Mockito.when(employeeService.retrieveEmployeeById(1L)).thenReturn(employeeDto);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("Mennatallah"))
                .andExpect(jsonPath("$.email").value("mennatallah.yahia@example.com"));
    }
}
