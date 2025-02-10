package com.employee.management.demo.mapper;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.dto.EmployeeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-10T02:22:57+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (IBM Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setFirstname( employee.getFirstname() );
        employeeDto.setLastname( employee.getLastname() );
        employeeDto.setEmail( employee.getEmail() );
        employeeDto.setDepartment( employee.getDepartment() );
        employeeDto.setSalary( employee.getSalary() );

        return employeeDto;
    }

    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setFirstname( employeeDto.getFirstname() );
        employee.setLastname( employeeDto.getLastname() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setDepartment( employeeDto.getDepartment() );
        employee.setSalary( employeeDto.getSalary() );

        return employee;
    }

    @Override
    public Employee toEmployee(EmployeeDto employeeDto, long employeeId) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        if ( employeeDto != null ) {
            employee.setFirstname( employeeDto.getFirstname() );
            employee.setLastname( employeeDto.getLastname() );
            employee.setEmail( employeeDto.getEmail() );
            employee.setDepartment( employeeDto.getDepartment() );
            employee.setSalary( employeeDto.getSalary() );
        }
        employee.setId( employeeId );

        return employee;
    }
}
