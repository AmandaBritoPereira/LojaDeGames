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
@RequestMapping("/loja")
public class CategoriaController {
	
	/**
	 * Fazer vínculo com a CategoriaRepository
	 * @Autowired anotação para injeção de dependência
	 * @param repository
	 */
	@Autowired
	private CategoriaRepository repository;

	/**
	 * Pesquisar todos os dados da CategoriaModel
	 *  
	 * NomeObjeto: Buscar Categoria
	 * @GetMapping Método HTTP
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/buscarcategoria")
	public ResponseEntity<List<CategoriaModel>> BuscarCategoria() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	/**
	 * Pesquisar os dados na aplicação conforme o atributo (param)
	 * 
	 * @GetMapping Método HTTP 
	 * @NomeObjeto:BuscarNome
	 * @param descricao
	 * @return para a aplicação: status e inf no corpo da requisição
	 */
	@GetMapping("/buscarnome")
	public ResponseEntity<List<CategoriaModel>> BuscarNome(@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	/**
	 * Adicionar novos atributos à tabela CategoriaModel
	 * 
	 * @PostMapping (Método HTTP), adicionar dados através do instanciamento de um objeto (param)
	 * @NomeObjeto: AdicionarCategoria
	 * @param NovaCategoria
	 * @returnstatus (para aplicação)
	 * 		NovaCategoria retorna com infs no corpo da requisição
	 * 		save: salva as infos retornadas no corpo da requisição
	 */
	@PostMapping("/adicionar")
	public ResponseEntity<CategoriaModel> AdicionarCategoria(@Valid @RequestBody CategoriaModel NovaCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(NovaCategoria));
	}

	/* Anotação:
	 * Versão Post simplificada: public List<CategoriaModel> BuscarAleatorio () {
	 * return repository.findAll(); }
	 */
}
