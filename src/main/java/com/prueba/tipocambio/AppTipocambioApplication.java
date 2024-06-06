package com.prueba.tipocambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AppTipocambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTipocambioApplication.class, args);
	}

}
