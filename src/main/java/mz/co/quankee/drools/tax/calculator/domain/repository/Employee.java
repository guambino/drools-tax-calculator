package mz.co.quankee.drools.tax.calculator.domain.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "QUANKEE_DEMO")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = -4529732593312400942L;

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "BIRTHDATE")
    private LocalDate birthdate;

    @Column(name = "MONTHLY_INCOME")
    private BigDecimal monthlyIncome;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(birthdate, employee.birthdate) && Objects.equals(monthlyIncome, employee.monthlyIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, birthdate, monthlyIncome);
    }
}
