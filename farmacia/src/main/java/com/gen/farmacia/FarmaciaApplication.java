package com.gen.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FarmaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
	}

	@ManyToOne
	@JoinColumn(name = "tb_categoria")
	@JsonIgnoreProperties({"categoria"})
	private @NotBlank CategoriaModel nomeCategoria;

	@ManyToOne
	@JoinColumn(name = "tb_produto")
	@JsonIgnoreProperties({"produto"})
	private @NotBlank ProdutoModel nomeProduto;

	public ProdutoModel getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(ProdutoModel nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public CategoriaModel getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(CategoriaModel nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}