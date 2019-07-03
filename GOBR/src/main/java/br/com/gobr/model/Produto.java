package br.com.gobr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "produto")
public class Produto{

    @Id
    @GeneratedValue
    private Integer idProduto;
    private String descricao;
    private Float valorVarejo;
    private Float valorAtacado;
    private String codBarras;
    private String marca;
    private Float quantEstoque;
    private Float quantMin;
    private Float quantMax;
    
    @ManyToOne
	private Compra compra;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorVarejo() {
        return valorVarejo;
    }

    public void setValorVarejo(Float valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    public Float getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(Float valorAtacado) {
        this.valorAtacado = valorAtacado;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(float quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public float getQuantMin() {
        return quantMin;
    }

    public void setQuantMin(float quantMin) {
        this.quantMin = quantMin;
    }

    public float getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(float quantMax) {
        this.quantMax = quantMax;
    }    
}