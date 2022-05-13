package com.wallet.extrato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ExtratoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtratoApplication.class, args);
		System.out.println("Extrato iniciado");
	}

}
