package mz.co.quankee.drools.tax.calculator;

import mz.co.quankee.drools.tax.calculator.repository.config.RepositoryConfig;
import mz.co.quankee.drools.tax.calculator.rule.config.RuleConfig;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RepositoryConfig.class, RuleConfig.class})
public abstract class AbstractTaxCalculatorTest {
}
