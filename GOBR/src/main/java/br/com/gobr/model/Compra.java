package br.com.gobr.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "compra")
public class Compra{

	@Id
	@GeneratedValue
	private Integer idCompra;
	private LocalDate dataCompra;
	private float valorCompra;
	
	@ManyToOne
	private Funcionario idFuncionario;

	// Aqui vai gerar a tabela HistoricoCompra
	@ManyToMany(targetEntity = Produto.class, fetch = FetchType.LAZY)
	@JoinTable(name = "HistoricoCompra", 
		joinColumns = @JoinColumn(name = "idCompra"), 
		inverseJoinColumns = @JoinColumn(name = "idProduto")
		)
	private List<Produto> produtos;
	
	
	public List getProdutos() {
		return produtos;
	}

	public void setProdutos(List produtos) {
		this.produtos = produtos;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Funcionario getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Funcionario idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
