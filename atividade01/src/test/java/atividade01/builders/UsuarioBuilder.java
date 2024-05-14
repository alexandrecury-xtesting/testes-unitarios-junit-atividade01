package atividade01.builders;

import atividade01.Usuario;

public class UsuarioBuilder {
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private String password;
	private int age;
	private String uf;
	private long current_agency_id;
	
	private UsuarioBuilder () {}
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		inicializaDadosPadroes(builder);
		return builder;
	}

	private static void inicializaDadosPadroes(UsuarioBuilder builder) {
		builder.id = 1L;
		builder.name = "Nome Válido";
		builder.email = "user@mail.com";
		builder.cpf = "00000000000";
		builder.password = "password";
		builder.age = 25;
		builder.current_agency_id = 0;
		builder.uf = "BA";
	}
	
	public UsuarioBuilder addId(Long param) {
		id = param;
		return this;
	}
	
	public UsuarioBuilder addName(String param) {
		name = param;
		return this;
	}
	
	public UsuarioBuilder addAge(int param) {
		age = param;
		return this;
	}

	public UsuarioBuilder addEmail(String param) {
		email = param;
		return this;
	}
	
	public Usuario build() {
		return new Usuario(id, name, email, cpf, password, age, uf, current_agency_id);
	}

}
