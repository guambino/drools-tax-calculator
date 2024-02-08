package mz.co.quankee.drools.tax.calculator;

import mz.co.quankee.drools.tax.calculator.repository.config.RepositoryConfig;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RepositoryConfig.class})
public abstract class AbstractTaxCalculatorTest {
}
