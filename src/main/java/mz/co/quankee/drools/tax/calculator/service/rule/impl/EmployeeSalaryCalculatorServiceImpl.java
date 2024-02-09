package mz.co.quankee.drools.tax.calculator.service.rule.impl;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;
import mz.co.quankee.drools.tax.calculator.rule.EmployeeSalaryCalculator;
import mz.co.quankee.drools.tax.calculator.service.repository.EmployeeService;
import mz.co.quankee.drools.tax.calculator.service.rule.EmployeeSalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryCalculatorServiceImpl implements EmployeeSalaryCalculatorService {

    private final EmployeeService employeeService;

    private final EmployeeSalaryCalculator employeeSalaryCalculator;

    @Autowired
    public EmployeeSalaryCalculatorServiceImpl(EmployeeService employeeService, EmployeeSalaryCalculator employeeSalaryCalculator) {
        this.employeeService = employeeService;
        this.employeeSalaryCalculator = employeeSalaryCalculator;
    }

    @Override
    public List<EmployeeDto> calculateAllSalaries() {
        List<EmployeeDto> employees = employeeService.listAllEmployees();

        employeeSalaryCalculator.calculateSalary(employees);

        return employees;
    }
}
