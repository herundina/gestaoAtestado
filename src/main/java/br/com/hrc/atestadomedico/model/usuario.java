package br.com.hrc.atestadomedico.model;

import javax.persistence.*;

@Entity
@Table(name="login_usuario")
public class usuario {

	private String login;
	private Long id;
	private String senha;
	private String grupo;

	public usuario() {}

	public usuario(Long id, String nome, String senha, String grupo) {
		this.id = id;
		this.login = nome;
		this.senha = senha;
		this.grupo = grupo;		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId_usuario() {
		return id;
	}

	public void setId_usuario(Long id) {
		id = id;
	}
	
	@Column(name="nome_usuario", nullable = false)
	public String getNome_Login() {
		return login;
	}

	public void setNome_Login(String nome_Login) {
		this.login = nome_Login;
	}

	@Column(name="senha", nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name="grupo_usuario", nullable = false)
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String toString() {
		return "[ id: " + id + " Usuário: " + login + " senha: " + senha + "Grupo: " + grupo
				+ "Funcionário: ]";
	}
}