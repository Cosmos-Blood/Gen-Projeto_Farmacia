package com.gen.farmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen.farmacia.model.ProdutoModel;
import com.gen.farmacia.repository.ProdutoRepository;

/*CategoriaController Com 5 endpoints:
1 - findAllCategoria = endPoint com a capacidade de trazer todas as categorias (testar o MÉTODO findAll através do POSTMAN);
2 - findByIDCategoria = endPoint com a função de trazer uma única categoria por id (testar o MÉTODO findByID via postman);
3 - findByDescricaoCategoria = endPoint com a função de trazer uma categoria turma por Descricao;
4 - postCategoria = endPoint com a função de gravar uma nova categoria no banco de dados (testar o MÉTODO post via postman);
5 - putCategoria = endPoint com a função de atualizar dados de uma categoria (testar o MÉTODO put no postman);
6 - deleteCategoria = endPoint com a função de apagar uma categoria do banco de dados (testar o MÉTODO delete no postman).*/

@RestController
@RequestMapping("/api/v1/produto")
@CrossOrigin("*")
public class ProdutoController {
	private @Autowired ProdutoRepository repositorio;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll() {
		List<ProdutoModel> objetoProduto = repositorio.findAll();
		if (objetoProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoProduto);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findAllById(@Valid @PathVariable(value = "id") Long id) {
		Optional<ProdutoModel> objetoOptional = repositorio.findById(id);
		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}

	}

	@PostMapping("/novo")
	public ResponseEntity<ProdutoModel> salvarProduto(@Valid @RequestBody ProdutoModel novoProduto) {
		return ResponseEntity.status(200).body(repositorio.save(novoProduto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<ProdutoModel> atualizarProduto(@Valid @RequestBody ProdutoModel alterarProduto) {
		return ResponseEntity.status(200).body(repositorio.save(alterarProduto));
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<ProdutoModel> deletarProduto(@Valid @PathVariable(value = "id") Long id) {
		Optional<ProdutoModel> objetoOptional = repositorio.findById(id);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(id);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
