package com.employee.management.demo.mapper;

import com.employee.management.demo.domain.Employee;
import com.employee.management.demo.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);

    @Mapping(target = "id", source = "employeeId")
    Employee toEmployee(EmployeeDto employeeDto, long employeeId);
}
