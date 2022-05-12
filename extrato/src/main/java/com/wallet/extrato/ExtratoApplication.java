package com.wallet.extrato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExtratoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtratoApplication.class, args);
		System.out.println("Extrato iniciado");
	}

}
