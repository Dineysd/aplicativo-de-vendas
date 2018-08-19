package com.dineydev.appVendas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dineydev.appVendas.model.Categoria;
import com.dineydev.appVendas.repository.CategoriaRepository;

@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository catRepo;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria( null , "Informatica");
		Categoria cat2 = new Categoria( null , "Escritorio");
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		
	}
}
