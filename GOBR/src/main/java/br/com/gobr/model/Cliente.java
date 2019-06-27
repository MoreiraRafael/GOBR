package br.com.gobr.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "cliente")
@NamedQueries({@NamedQuery(name="Cliente.findByName", query="SELECT c FROM Cliente c WHERE c.nome = :nome")})
public class Cliente extends Pessoa {

	private LocalDate dataCadastro;

	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
	//private Collection<Venda> listaVenda;

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}