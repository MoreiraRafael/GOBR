package br.com.gobr.model;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "cliente")
public class Cliente extends Pessoa {

	private LocalDate dataCadastro;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
	private Collection<Venda> listaVenda;

	public Collection<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(Collection<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}