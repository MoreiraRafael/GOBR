package br.com.gobr.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue
	private Integer idVenda;
	private LocalDate dataVenda;
	
	// Aqui, os objetos Cliente e Funcion�rio comp�em uma venda
	@ManyToOne
	private Cliente cliente; // Obs.: Como � usado uma InheritanceType.JOINED, o nome do atributo do id do cliente ser� idPessoa 
	
	@ManyToOne
	private Funcionario funcionario; // Obs.: O coment�rio da linha 27 serve para o funcionario
	
	// Aqui vai gerar minha tabela HistoricoVenda
	@ManyToMany(targetEntity = Produto.class, fetch = FetchType.LAZY)
	@JoinTable(name = "HistoricoVenda", 
		joinColumns = @JoinColumn(name = "idVenda"), 
		inverseJoinColumns = @JoinColumn(name = "idProduto")
		)
	private List produtos;

	public Cliente getCliente() {
		return cliente;
	}

	public void setIdCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List getProdutos() {
		return produtos;
	}

	public void setProdutos(List produtos) {
		this.produtos = produtos;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
