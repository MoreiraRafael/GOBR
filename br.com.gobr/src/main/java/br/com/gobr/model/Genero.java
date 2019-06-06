package br.com.gobr.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "genero")
public class Genero{

    @Id
    @GeneratedValue
    private Integer idGenero;
    private String descGenero;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenero")
    private Collection<Pessoa> listaPessoas;

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescGenero() {
        return descGenero;
    }

    public void setDescGenero(String descGenero) {
        this.descGenero = descGenero;
    }
    
}
