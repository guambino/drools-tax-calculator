package mz.co.quankee.drools.tax.calculator.service.repository;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> listAllEmployees();
}
