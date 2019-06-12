package br.com.gobr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String rg;

	@OneToOne
	// @JoinColumn(name = "idEndereco", nullable = false)
	private Endereco endereco;
	
	
	private char genero;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getIdEndereco() {
		return endereco;
	}

	public void setIdEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public char getIdGenero() {
		return genero;
	}

	public void setIdGenero(char genero) {
		this.genero = genero;
	}

}
