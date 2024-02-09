# drools-tax-calculator
A Demo of Drools Rule Engine with Spring Boot

# Introduction
The whole idea is to showcase Drools Rules Engine with Spring Boot and sample data on H2.

# Scenario: Government Taxes
# Pre Rule Validations
The set of rules only apply for individuals aged between 18 and 65. 

# Rules
see rules.docx

# build
mvn clean install

# Run
mvn spring-boot:run

#URL
http://localhost:8080/drools/tax/calculator/swagger-ui/index.html