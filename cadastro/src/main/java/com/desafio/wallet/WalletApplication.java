package com.desafio.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories
@SpringBootApplication
public class WalletApplication {

	@Bean
	public RestTemplate buildRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {

		SpringApplication.run(WalletApplication.class, args);
		System.out.println("Cadastro iniciado");
	}

}
