package com.employee.management.demo.dto;


import com.employee.management.demo.annotation.ValidEmail;
import jakarta.validation.constraints.*;

public class EmployeeDto {
    private long id;
    @NotEmpty(message = "The first name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String firstname;
    @NotEmpty(message = "The last name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String lastname;
    @NotEmpty(message = "The email is required.")
    @ValidEmail
    private String email;
    @NotEmpty(message = "The department is required.")
    private String department;
    @NotNull(message = "The salary is required.")
    private Double salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

