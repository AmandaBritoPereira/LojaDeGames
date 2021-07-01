package com.sualoja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sualoja.games.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	//nome do método findByAllDescricaoContening
	List<CategoriaModel>findAllByDescricaoContaining(String descricao);

}
