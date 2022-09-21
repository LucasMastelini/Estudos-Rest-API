package com.open.feingn.application.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignApplication implements CommandLineRunner {

	@Autowired
	IConnectOpen connectOpen;

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(
				connectOpen.listar()
		);
	}
}
