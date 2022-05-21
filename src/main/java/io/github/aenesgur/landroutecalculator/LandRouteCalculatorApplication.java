package io.github.aenesgur.landroutecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LandRouteCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandRouteCalculatorApplication.class, args);
	}

}
