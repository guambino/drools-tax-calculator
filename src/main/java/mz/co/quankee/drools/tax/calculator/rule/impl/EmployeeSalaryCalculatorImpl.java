package mz.co.quankee.drools.tax.calculator.rule.impl;

import mz.co.quankee.drools.tax.calculator.domain.dto.EmployeeDto;
import mz.co.quankee.drools.tax.calculator.rule.EmployeeSalaryCalculator;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSalaryCalculatorImpl implements EmployeeSalaryCalculator {

    private final KieContainer kieContainer;

    @Autowired
    public EmployeeSalaryCalculatorImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public void calculateSalary(List<EmployeeDto> employees) {
        KieSession kieSession = kieContainer.newKieSession();
        employees.forEach(kieSession::insert);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
