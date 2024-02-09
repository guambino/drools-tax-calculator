package mz.co.quankee.drools.tax.calculator.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;
import mz.co.quankee.drools.tax.calculator.service.rule.EmployeeSalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name = "Salary Calculator Controller", description = "Salary Calculator Controller")
public class SalaryCalculatorController {

    private final EmployeeSalaryCalculatorService employeeSalaryCalculatorService;

    @Autowired
    public SalaryCalculatorController(EmployeeSalaryCalculatorService employeeSalaryCalculatorService) {
        this.employeeSalaryCalculatorService = employeeSalaryCalculatorService;
    }

    @GetMapping("/all")
    @Operation(summary = "Calculate All Employee Salaries", description = "Calculate All Employee Salaries")
    public ResponseEntity<List<EmployeeDto>> calculateAllSalaries(){
        List<EmployeeDto> employees = employeeSalaryCalculatorService.calculateAllSalaries();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
