package mz.co.quankee.drools.tax.calculator.rule;

import mz.co.quankee.drools.tax.calculator.AbstractTaxCalculatorTest;
import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeSalaryCalculatorTest extends AbstractTaxCalculatorTest {

    @Autowired
    private EmployeeSalaryCalculator employeeSalaryCalculator;

    @Test
    public void calculateSalaryMinor(){
        List<EmployeeDto> employees = getEmployees();
        employeeSalaryCalculator.calculateSalary(employees);

        //Validate for a minor
        EmployeeDto employee = employees.get(0);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(0.0, employee.getNetMonthlyIncome());
        assertEquals(0.0, employee.getTax());

        //validate for 18 older
        employee = employees.get(2);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(9000.0, employee.getNetMonthlyIncome());
        assertEquals(0.0, employee.getTax());


        employees.forEach(System.out::println);

    }

    private List<EmployeeDto> getEmployees(){
        return List.of(getEmployee("E100001","Hans Solo", 15,0.0),
                getEmployee("E100002","Luke Skywalker",70,102933.0),
                getEmployee("E100003","Leia Organa",18,9000.0));
    }

    private EmployeeDto getEmployee(String employeeId, String employeeName, Integer employeeAge, Double monthlyIncome){
        return EmployeeDto.builder()
                .employeeId(employeeId)
                .monthlyIncome(monthlyIncome)
                .employeeName(employeeName)
                .employeeAge(employeeAge)
                .build();
    }
}
