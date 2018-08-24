package com.dineydev.appVendas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dineydev.appVendas.model.Categoria;
import com.dineydev.appVendas.model.Produto;
import com.dineydev.appVendas.repository.CategoriaRepository;
import com.dineydev.appVendas.repository.ProdutoRepository;

@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodrepo;

	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria( null , "Informatica");
		Categoria cat2 = new Categoria( null , "Escritorio");
		
		Produto p1 = new Produto(null, "computador", 2790.00);
		Produto p2 = new Produto(null, "impressora", 890.00);
		Produto p3 = new Produto(null, "mouse", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		prodrepo.saveAll(Arrays.asList(p1, p2, p3));
		
	}
}
