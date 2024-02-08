package mz.co.quankee.drools.tax.calculator.repository;

import mz.co.quankee.drools.tax.calculator.domain.repository.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
