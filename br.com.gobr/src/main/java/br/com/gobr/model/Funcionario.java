package br.com.gobr.model;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private String funcao;
	private double salario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
	private Collection<Venda> listaVenda;

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Collection<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(Collection<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
