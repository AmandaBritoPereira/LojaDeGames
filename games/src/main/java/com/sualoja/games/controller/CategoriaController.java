package com.sualoja.games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sualoja.games.model.CategoriaModel;
import com.sualoja.games.repository.CategoriaRepository;
//import com.sualoja.games.service.CategoriaService;

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
	 * Fazer vínculo com a CategoriaService
	 * @Autowired anotação para injeção de dependência
	 * @param service
	@Autowired
	private CategoriaService service;
	*/
	
	/**
	 * Pesquisar todos os dados da CategoriaModel
	 *  
	 * @NomeObjeto: BuscarCategoria
	 * @GetMapping Método HTTP
	 * @return para a aplicação: status e info no corpo da requisição
	 */
	@GetMapping("/categoria")
	public ResponseEntity<List<CategoriaModel>> BuscarCategoria() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	/**
	 * Pesquisar a categoria conforme o id especificado na url
	 * 
	 * @NomeObjeto BuscarIdCategoria
	 * @param idCategoria
	 * @return para a aplicação: status e info no corpo da requisição
	 */	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<CategoriaModel> BuscarIdCategoria(@PathVariable long idCategoria){
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

		
	/**
	 * Pesquisar os dados na aplicação conforme o atributo (param)
	 * 
	 * @GetMapping Método HTTP 
	 * @NomeObjeto:BuscarDescricao
	 * @param descricao
	 * @return para a aplicação: status e inf no corpo da requisição
	 */
	@GetMapping("/categoria/descricao")
	public ResponseEntity<List<CategoriaModel>> BuscaDescricao (@RequestParam String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	/**
	 * Adicionar novos atributos à tabela CategoriaModel
	 * 
	 * @PostMapping (Método HTTP), adicionar dados através do instanciamento de um objeto (param)
	 * @NomeObjeto: AdicionarCategoria
	 * @param NovaCategoria
	 * @returnstatus utilizada em conjuto com uma aplicação
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
	
	/**
	 * Alteracao de dados da tabela CategoriaModel
	 * @NomeObjeto put
	 * @param alteracao
	 * @return utilizada em conjuto com uma aplicação
	 * 		alteracao: retorna com infs no corpo da requisição
	 * 		save: salva as infos retornadas no corpo da requisição
	 */
	@PutMapping ("/alterar")
		public  ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel alteracao){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(alteracao));
		
	}

	/**
	 * Ampliação para Service, em teste
	 * Atualizar o atributo nome
	 * @param idCategoria
	 * @param NovaAlteracao
	 * @return atualizar no repositorio,
	 * 		map. mapear o retorno de status (200 ou 400)
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<CategoriaModel> AlterarCategoria(@Valid @PathVariable (value = "id") long idCategoria,
			@Valid @RequestBody CategoriaModel NovaAlteracao) {
		return service.atualizarCategoria(idCategoria,NovaAlteracao).map(atu -> ResponseEntity.status(200).body(atu))
				.orElse(ResponseEntity.badRequest().build());
	}*/
}
