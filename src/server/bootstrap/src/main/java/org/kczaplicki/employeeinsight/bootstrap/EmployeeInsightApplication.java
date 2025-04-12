package org.kczaplicki.employeeinsight.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.kczaplicki.employeeinsight")
public class EmployeeInsightApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInsightApplication.class, args);
	}

}
