package com.employee.management.demo.service;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.dto.EmployeeDto;
import com.employee.management.demo.mapper.EmployeeMapper;
import com.employee.management.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        logger.info("Creating a new employee");
        return employeeMapper.toEmployeeDto(employeeRepository.save(employeeMapper.toEmployee(employeeDto)));
    }

    public EmployeeDto retrieveEmployeeById(long id) {
        logger.info("Getting employee by id {}",id);
        return employeeMapper.toEmployeeDto(employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No employee found for that id!")));
    }

    public List<EmployeeDto> retrieveAllEmployees() {
        logger.info("Getting all employees");
        return employeeRepository.findAll().stream().map(employeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    public EmployeeDto modifyEmployeeById(long id, EmployeeDto employeeDto) {
        logger.info("Getting employee by id {} before modifying", id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No employee found for that id!"));
        logger.info("Modifying employee by id {}", id);
        return employeeMapper.toEmployeeDto(employeeRepository.save(employeeMapper.toEmployee(employeeDto, employee.getId())));
    }

    public void removeEmployeeById(long id) {
        logger.info("Getting employee by id {} before deleting", id);
        employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No employee found for that id!"));
        logger.info("Deleting employee by id {}", id);
        employeeRepository.deleteById(id);
    }
}
