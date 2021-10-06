package com.gen.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe espelho da tabela produto no banco db_farmacia.
 * 
 * @author Macauly Fragoso
 * @since 1.0
 *
 */

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotBlank @Size(min = 5, max = 100) String nomeProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@OneToMany(mappedBy = "nomeProduto", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"nomeProduto"})
	private List<ProdutoModel> produto = new ArrayList<>();

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

}