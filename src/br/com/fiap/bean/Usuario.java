package br.com.fiap.bean;

public class Usuario {
	
	private int id;
	private String nomeUser;
	private String passUser;
	private String nome;
	private String urlAvatar;
	
	public Usuario() {
	}

	public Usuario(int id, String nomeUser, String passUser, String nome, String urlAvatar) {
		super();
		this.id = id;
		this.nomeUser = nomeUser;
		this.passUser = passUser;
		this.nome = nome;
		this.urlAvatar = urlAvatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getPassUser() {
		return passUser;
	}

	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}
	
	@Override
	public String toString() {
		return "<%User '" + getNomeUser() + "'>";
	}
	
}
