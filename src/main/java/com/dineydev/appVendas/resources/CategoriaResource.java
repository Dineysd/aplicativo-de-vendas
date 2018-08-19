package com.dineydev.appVendas.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dineydev.appVendas.model.Categoria;
import com.dineydev.appVendas.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaPorId(@PathVariable Integer id) {
		
		/*Categoria cat1 = new Categoria( 1 , "Informatica");
		Categoria cat2 = new Categoria( 2 , "Escritorio");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);*/
		
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
