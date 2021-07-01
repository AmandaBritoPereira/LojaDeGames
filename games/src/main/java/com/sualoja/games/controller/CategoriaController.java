package com.sualoja.games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sualoja.games.model.CategoriaModel;
import com.sualoja.games.repository.CategoriaRepository;

@RestController
@RequestMapping ("/loja")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/buscarcategoria")
	public ResponseEntity<List<CategoriaModel>> BuscarCategoria () {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	@GetMapping("/buscarnome")
	public ResponseEntity<List<CategoriaModel>> BuscarNome (@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}
	
	@PostMapping ("/adicionar")
	public ResponseEntity<CategoriaModel> adicionar (@Valid @RequestBody CategoriaModel NovaCategoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(NovaCategoria));
	}
	
	/*Versão simplificada
	 * public List<CategoriaModel> BuscarAleatorio () {
		return repository.findAll();
	} */
}
