package mz.co.quankee.drools.tax.calculator.rule;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeSalaryCalculator {

    void calculateSalary(List<EmployeeDto> employees);
}
