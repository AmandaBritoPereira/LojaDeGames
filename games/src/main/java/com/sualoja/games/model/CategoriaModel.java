package com.sualoja.games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class CategoriaModel {
	
	//Atributos e anotações
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min = 3)
	private String nome;
	
	@NotEmpty
	private float preco;
	
	private String descricao;
	
	@NotEmpty
	private boolean disposicao;

	public long getId() {
		return id;
	}
	
	//Métodos getters e setters
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
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
