package com.avaliacaosprint.AvaliacaoSprint3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Carro {

    @ApiModelProperty(value = "Código único do carro")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @ApiModelProperty(value = "Nome do carro")
    @Column(nullable = false)
    private String nome;
    
    @ApiModelProperty(value = "Numero do chassi")
    @Column(nullable = false, unique=true)
    private String chassi;

    @ApiModelProperty(value = "Marca do carro")
    @Column(nullable = false)
    private String marca;

    @ApiModelProperty(value = "Cor do carro")
    @Column(nullable = false)
    private String cor;

    @ApiModelProperty(value = "Valor do carro")
    @Column(nullable = false)
    private float valor;

    @ApiModelProperty(value = "Data de fabricação do carro")
    @Column(nullable = false)
    private int fabricacao;
    
    Carro() {}

    Carro(String chassi, String nome, String marca, String cor, float valor, int fabricacao) {
    	this.chassi = chassi;
    	this.nome = nome;
    	this.marca = marca;
    	this.cor = cor;
    	this.valor = valor;
    	this.fabricacao = fabricacao;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
	public String getChassi() {
		return this.chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return this.marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCor() {
		return this.cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public float getValor() {
		return this.valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getFabricacao() {
		return this.fabricacao;
	}
	public void setFabricacao(int fabricacao) {
		this.fabricacao = fabricacao;
	}
    
	@Override
	public String toString() {
		return "Carro{" + "id=" + this.id + ", name='" + this.nome + '\'' + ", fabricacao='" + this.fabricacao + '\'' + '}';
	}
	
	
	
}