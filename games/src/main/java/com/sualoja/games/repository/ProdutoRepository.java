package com.sualoja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sualoja.games.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	/**
	 * Pesquisar nos parametros do atributo, os caracteres informados na Aplicação
	 * 
	 * @método findAllByDescricaoProdutoContaining localizar e retornar os dados da
	 *         tabela sql
	 * @param descricaoProduto
	 * @return atributos da Model, onde os caracteres correspondem com os parametros
	 *         do atributo descricaoProduto
	 */
	List<ProdutoModel> findAllByDescricaoProdutoContaining(String descricaoProduto);

}
