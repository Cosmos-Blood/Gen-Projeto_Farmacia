package com.gen.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.farmacia.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	/*
	 * Método utilizado para realizar pesquisa pela coluna id da tabela produto
	 * 
	 * @param id
	 * @return List com ProdutoModel
	 * @author Macauly Fragoso
	 * @since 1.0
	 * 
	 */

	public Optional<ProdutoModel> findById(Long id);

	/*
	 * Método utilizado para realizar pesquisa pela coluna nome da tabela produto
	 * 
	 * @param nome
	 * @return List com ProdutoModel
	 * @author Macauly Fragoso
	 * @since 1.0
	 */

	public List<ProdutoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
}