package com.sualoja.games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Atributos utilizados na Classe/Interface: CategoriaController e CategoriaRepository
 * 
 * Last Update: junho 2021
 * @author Amanda Pereira
 */
@Entity
public class ProdutoModel {
	
	//Atributos utilizados na Classe/Interface: ProdutoController e ProdutoRepository
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;

	@NotEmpty(message = "É necessário informar algum caractere")
	@Size(min = 3)
	private String nomeproduto;

	@NotNull(message = "É necessário informar um valor para o produto")
	private float precoproduto;

	private String descricaoProduto;

	private boolean estoqueproduto;

	//Métodos getters e setters
	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public float getPrecoproduto() {
		return precoproduto;
	}

	public void setPrecoproduto(float precoproduto) {
		this.precoproduto = precoproduto;
	}

	public String getInformacoesproduto() {
		return descricaoProduto;
	}

	public void setInformacoesproduto(String informacoesproduto) {
		this.descricaoProduto = informacoesproduto;
	}

	public boolean isEstoqueproduto() {
		return estoqueproduto;
	}

	public void setEstoqueproduto(boolean estoqueproduto) {
		this.estoqueproduto = estoqueproduto;
	}

}
