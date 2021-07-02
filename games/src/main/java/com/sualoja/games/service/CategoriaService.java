package com.sualoja.games.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sualoja.games.model.CategoriaModel;
import com.sualoja.games.repository.CategoriaRepository;

/**
 * @deprecated
 * @version 0.1 Ainda em testes
 * @author Amanda Pereira
 */
@Service
public class CategoriaService {
	
	/**
	 * Fazer vínculo com a CategoriaRepository
	 * 
	 * @Autowired anotação para injeção de dependência
	 * @param repository
	 */
	public CategoriaRepository repository;

	/**
	 * 
	 * @param idCategoria
	 * @param NovaCategoria
	 * @param atualizarCategoria, objeto instanciado
	 * @return
	 */
	public Optional<CategoriaModel> atualizarCategoria(long idCategoria, CategoriaModel NovaCategoria) {
		return repository.findById(idCategoria).map(atualizar -> {
			atualizar.setNome(NovaCategoria.getNome());
			return Optional.ofNullable(repository.save(atualizar));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}