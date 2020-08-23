package com.serratec.java2.projetoEcommerce.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name = "produto")
public class Produto  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 200)
	private String descricao;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidade_estoque;
	
	@Past
	@Column(name = "data_fabricacao")
	private String data_fabricacao;
	
	@Column(name = "valor_unitario", nullable = false)
	private Double valor_unitario;
	
	//foreign keys
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario", referencedColumnName = "codigo")
	private Funcionario funcionario;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn (name = "codigo_produto", 
	referencedColumnName = "codigo"),
	inverseJoinColumns = @JoinColumn (name = "codigo_pedido", referencedColumnName = "codigo"))
	private List<Pedido> codigoPedido;
//	

	//Construtores
	public Produto() {
	}


	public Produto(Integer codigo, String nome, String descricao, Integer quantidade_estoque, String data_fabricacao,
			Double valor_unitario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade_estoque = quantidade_estoque;
		this.data_fabricacao = data_fabricacao;
		this.valor_unitario = valor_unitario;
	}


	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}


	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}


	public String getData_fabricacao() {
		return data_fabricacao;
	}


	public void setData_fabricacao(String data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}


	public Double getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

}
