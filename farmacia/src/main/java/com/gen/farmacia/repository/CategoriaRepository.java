package com.gen.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.farmacia.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	public Optional<CategoriaModel> findById(Long id);

	public List<CategoriaModel> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);

}
