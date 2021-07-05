package com.sualoja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sualoja.games.model.CategoriaModel;

/**
 * Estabelece a comunicação com o bando de dados (MySQL)
 * 
 * Last Update: junho 2021
 * 
 * @author Amanda Pereira
 */
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	/**
	 * Pesquisar nos parametros do atributo os caracteres informados na Aplicacao
	 * 
	 * @Método findByAllDescricaoContaining localizar os dados solicitados na tabela
	 * @param descricao
	 * @return atributos da Model, onde os caracteres correspondem com os parametros
	 *         do atributo descricao
	 */
	List<CategoriaModel> findAllByDescricaoContaining(String descricao);

}