package mz.co.quankee.drools.tax.calculator.repository.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = {"mz.co.quankee.drools.tax.calculator.domain.repository"})
@EnableJpaRepositories( basePackages = {"mz.co.quankee.drools.tax.calculator.repository"})
public class RepositoryConfig {
}
