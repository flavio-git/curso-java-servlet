package com.flavio.gerenciador.model;

import java.util.Objects;

public class Usuario {
	
	private static Integer CONTROLE_ID = 1; 
	private Integer id;
	private String login;
	private String senha;
	
	public Usuario() {
		this.id = Usuario.CONTROLE_ID++;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return this.login.equals(usuario.getLogin()) && this.senha.equals(usuario.getSenha());
    }

	@Override
    public int hashCode() {
        return Objects.hash(login, senha);
    }
	
	@Override
	public String toString() {
		return "{Id= " + this.id + ", Login= " + this.login + ", Senha= " + this.senha + "}";
	}
	
	
}
