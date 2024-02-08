package mz.co.quankee.drools.tax.calculator.repository;

import mz.co.quankee.drools.tax.calculator.AbstractTaxCalculatorTest;
import mz.co.quankee.drools.tax.calculator.domain.repository.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeRepositoryTest extends AbstractTaxCalculatorTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(1, employees.size());
    }
}
