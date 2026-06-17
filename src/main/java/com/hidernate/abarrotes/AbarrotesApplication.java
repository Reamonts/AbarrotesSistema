package com.hidernate.abarrotes;

import com.hidernate.abarrotes.entity.Productos;
import com.hidernate.abarrotes.repositorio.RepoProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AbarrotesApplication implements CommandLineRunner {

	@Autowired
	private RepoProdutos repoProduto;

	public static void main(String[] args) {
		SpringApplication.run(AbarrotesApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion iniciada correctamente");
	}
}
