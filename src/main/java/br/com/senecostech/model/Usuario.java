package br.com.senecostech.model;

public class Usuario {
	private int id;
	private String login, senha, endereco;
	
	public Usuario(String login, String senha, String endereco) {
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(int id, String login, String senha, String endereco) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtor para verificação de login e senha
	 * @param login
	 * @param senha
	 */
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
		// TODO Auto-generated constructor stub
	}
	
	public Usuario() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", endereco=" + endereco + "]";
	}
	
	public boolean Autenticacao(String login, String senha) {
		if(!(this.login.equals(login)&this.senha.equals(senha))) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	

}
