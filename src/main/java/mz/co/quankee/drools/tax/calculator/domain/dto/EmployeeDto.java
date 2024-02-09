package mz.co.quankee.drools.tax.calculator.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class EmployeeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5666992638892450512L;

    private String employeeId;

    private String employeeName;

    private Integer employeeAge;

    private Double monthlyIncome;

    private Double netMonthlyIncome;

    private Double tax;

    private String observation;
}
