package com.sualoja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sualoja.games.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
	
	/** Listar os dados a serem imputados no SQL
	 * @NomeObjeto findByAllDescricaoContening (deve ser escrito com letra maiuscula)
	 * @param descricao
	 * @return Lista com os atributos da CategoriaModel
	 */
	List<CategoriaModel>findAllByDescricaoContaining(String descricao);

}
