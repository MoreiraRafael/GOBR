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
	
	// Aqui, os objetos Cliente e Funcionário compõem uma venda
	@ManyToOne
	private Cliente idCliente;
	
	@ManyToOne
	private Funcionario idFuncionario;
	
	// Aqui vai gerar minha tabela HistoricoVenda
	@ManyToMany(targetEntity = Produto.class, fetch = FetchType.LAZY)
	@JoinTable(name = "HistoricoVenda", 
		joinColumns = @JoinColumn(name = "idVenda"), 
		inverseJoinColumns = @JoinColumn(name = "idProduto")
		)
	private List produtos;

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
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

	public Funcionario getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Funcionario idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
