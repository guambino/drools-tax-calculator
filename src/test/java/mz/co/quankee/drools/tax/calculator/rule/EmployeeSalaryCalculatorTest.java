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
        System.out.println(employee.getObservation());


    }

    @Test
    public void calculateSalaryRetired(){
        List<EmployeeDto> employees = getEmployees();
        employeeSalaryCalculator.calculateSalary(employees);

        //Validate for a retired
        EmployeeDto employee = employees.get(1);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(179990.0, employee.getNetMonthlyIncome());
        assertEquals(0.0, employee.getTax());
    }



    @Test
    public void calculateSalary18(){
        List<EmployeeDto> employees = getEmployees();
        employeeSalaryCalculator.calculateSalary(employees);

        //Validate for 18yr with less than 10000
        EmployeeDto employee = employees.get(2);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(9000.0, employee.getNetMonthlyIncome());
        assertEquals(0.0, employee.getTax());

        //validate for 18yr with between 10.000 and 20 0000
        employee = employees.get(3);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(13500.0, employee.getNetMonthlyIncome());
        assertEquals(10.0, employee.getTax());

    }

    @Test
    public void calculateSalaryBetween18And65(){
        List<EmployeeDto> employees = getEmployees();
        employeeSalaryCalculator.calculateSalary(employees);

        EmployeeDto employee = employees.get(4);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(16200.0, employee.getNetMonthlyIncome());
        assertEquals(10.0, employee.getTax());

        employee = employees.get(5);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(29750.0, employee.getNetMonthlyIncome());
        assertEquals(15.0, employee.getTax());
    }

    @Test
    public void calculateSalaryBetween30And60(){
        List<EmployeeDto> employees = getEmployees();
        employeeSalaryCalculator.calculateSalary(employees);

        EmployeeDto employee = employees.get(6);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(13600.0, employee.getNetMonthlyIncome());
        assertEquals(20.0, employee.getTax());

        employee = employees.get(7);
        assertNotNull(employee.getNetMonthlyIncome());
        assertNotNull(employee.getTax());
        assertEquals(24750.0, employee.getNetMonthlyIncome());
        assertEquals(25.0, employee.getTax());

    }

    private List<EmployeeDto> getEmployees(){
        return List.of(getEmployee("E100001","Hans Solo", 15,0.0),
                getEmployee("E100002","Luke Skywalker",70,102933.0),
                getEmployee("E100003","Leia Organa",18,9000.0),
                getEmployee("E100004","Obi-Wan Kenobi",18,15000.0),
                getEmployee("E100005","C-3PO",25,18000.0),
                getEmployee("E100006","R2-D2",27,35000.0),
                getEmployee("E100007","Chewbacca",40,17000.0),
                getEmployee("E100008","Darth Vader",45,33000.0));
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
