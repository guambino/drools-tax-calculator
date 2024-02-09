package mz.co.quankee.drools.tax.calculator.web.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Drools Tax Calculator Demo").description(
                                "Drools Tax Calculator Demo").version("1.0.0-SNAPSHOT")
                        .contact(new Contact().name("Quankee Developers")
                                .url("https://github.com/guambino/drools-tax-calculator.git")));
    }
}
