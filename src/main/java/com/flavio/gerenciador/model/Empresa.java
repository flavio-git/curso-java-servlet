package com.flavio.gerenciador.model;

import java.util.Date;

public class Empresa {

	private static Integer CONTROLE_ID = 1;
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Empresa() {
		this.id = Empresa.CONTROLE_ID;
		Empresa.CONTROLE_ID++;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	@Override
	public String toString() {
		return "{Id: " + this.id + ", Nome: " + this.nome + ", Abertura: " + this.dataAbertura + "}";
	}
	
	
}
