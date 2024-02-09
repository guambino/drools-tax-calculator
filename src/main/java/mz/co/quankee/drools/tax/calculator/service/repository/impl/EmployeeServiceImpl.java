package mz.co.quankee.drools.tax.calculator.service.repository.impl;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;
import mz.co.quankee.drools.tax.calculator.repository.EmployeeRepository;
import mz.co.quankee.drools.tax.calculator.service.repository.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> listAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(employee -> {
            employees.add(EmployeeDto.builder()
                            .employeeAge(getAge(employee.getBirthdate()))
                            .employeeId(employee.getEmployeeId())
                            .employeeName(employee.getEmployeeName())
                            .monthlyIncome(employee.getMonthlyIncome().doubleValue())
                    .build());
        });
        return employees;
    }

    private Integer getAge(LocalDate date){
        return Period.between(date, LocalDate.now()).getYears();
    }
}
