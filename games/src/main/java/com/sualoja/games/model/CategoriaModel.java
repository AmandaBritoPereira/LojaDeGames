package com.sualoja.games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Abstração e instanciação de objetos/recursos
 * 
 * Last Update: junho 2021
 * 
 * @author Amanda Pereira
 */
@Entity
public class CategoriaModel {

	/*
	 * Atributos utilizados na Classe/Interface: CategoriaController e
	 * CategoriaRepository
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	@NotEmpty
	@Size(min = 3)
	private String nome;

	private String descricao;

	private boolean disposicao;

	/**
	 * Estrutura dos dados, criação do relacionamento entre tabelas no MySQL
	 * 
	 * @ManyToOne estrutura relacional
	 * @JsonIgnoreProperties produto, evita recursividade na exibição dos dados
	 */
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	public ProdutoModel produto;

	// Métodos getters e setters
	public long getId() {
		return idCategoria;
	}

	public void setId(long id) {
		this.idCategoria = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisposicao() {
		return disposicao;
	}

	public void setDisposicao(boolean disposicao) {
		this.disposicao = disposicao;
	}

}
