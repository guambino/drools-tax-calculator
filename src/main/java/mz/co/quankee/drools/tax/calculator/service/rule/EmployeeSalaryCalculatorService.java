package mz.co.quankee.drools.tax.calculator.service.rule;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeSalaryCalculatorService {

    List<EmployeeDto> calculateAllSalaries();
}
