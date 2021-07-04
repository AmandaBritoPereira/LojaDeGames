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

import com.sualoja.games.model.ProdutoModel;
import com.sualoja.games.repository.ProdutoRepository;


/**
 * Estabelece a comunicação com o bando de dados (MySQL)
 * 
 * Last Update: julho 2021
 * @author Amanda Pereira
 */
@RestController
@RequestMapping ("/produto")
public class ProdutoController {

	@Autowired
	public ProdutoRepository repository;
	
	/**
	 * Pesquisar todos os parametros da ProdutoModel
	 * 
	 * @NomeObjeto: BuscarProdutos
	 * @GetMapping Método HTTP
	 * @return para a Aplicação: status e info no corpo da requisição
	 */
	@GetMapping ("/produto")
	public ResponseEntity<List<ProdutoModel>> BuscarProdutos(){
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	/**
	 * Pesquisar os parametros da model, conforme a busca específica no atributo descricao
	 * 
	 * @GetMapping Método HTTP
	 * @NomeObjeto:BuscarDescricaoProduto
	 * @param descricaoProduto
	 * @return para a aplicação: status e inf no corpo da requisição
	 */
	@GetMapping ("/produto/descricao")
	public ResponseEntity<List<ProdutoModel>> BuscarDescricaoProduto (@RequestParam String descricaoProduto){
		return ResponseEntity.status(200).body(repository.findAllByDescricaoProdutoContaining(descricaoProduto));
	}
	/**
	 * Adicionar parametros aos atributos, da classe ProdutoModel
	 * 
	 * @NomeMétodo AdicionarProduto
	 * @param NovoProduto, Objeto instânciado para transportar informações
	 * @return status 201 e infs requisitadas pelo @RequestBody
	 */
	@PostMapping ("/adicionar")
	public ResponseEntity<ProdutoModel> AdicionarProduto (@Valid @RequestBody ProdutoModel NovoProduto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(NovoProduto));
	}
}
