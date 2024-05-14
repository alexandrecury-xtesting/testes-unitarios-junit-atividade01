package atividade01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade01.builders.UsuarioBuilder;

class UsuarioTest {
	
	public Usuario usuario;
	
	@BeforeEach
	void setup() {
		usuario = UsuarioBuilder.umUsuario().build();
	}	

	@Test
	void testBuildUsuarioComIdadeValido() {
		Usuario usuario = UsuarioBuilder.umUsuario().addAge(33).build();
		assertEquals(33, usuario.getAge());
	}
	
	@Test
	void testBuildUsuarioComIdadeInvalido() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
//			UsuarioBuilder.umUsuario().addAge(90).build();
			new Usuario(1L, "Algum nome", "email", "00000000001", "password", 90, "BA", 1L);
		});
		assertEquals("Idade do Usuário não permitido para cadastramento", e.getMessage());
	}
	
	@Test
	void testBuildUsuarioComNomeValido() {
		Usuario usuario = new Usuario(1L, "nome_valido", "user@mail.com", "00000000000", "password", 18, "BA", 0);
		assertEquals("nome_valido", usuario.getName());
	}
	
	@Test
	void testBuildUsuarioComNomeInvalido() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			new Usuario(1L, null, "user@mail.com", "00000000000", "password", 18, "BA", 0);
		});
		assertEquals("Nome é obrigatório", e.getMessage());
	}
	
	@Test
	void testBuildUsuarioComEmailValido() {
		Usuario usuario = new Usuario(1L, "nome_valido", "user@mail.com", "00000000000", "password", 18, "BA", 0);
		assertEquals("user@mail.com", usuario.getEmail());
	}
	
	@Test
	void testDeveRejeitarUsuarioSemEmail() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			new Usuario(1L, "nome_valido", null, "00000000000", "password", 18, "BA", 0);
		});
		assertEquals("Email é obrigatório", e.getMessage());
	}
	
	@Test
	void testBuildUsuarioComIdadeInvalidoAbaixoDe18() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			new Usuario(1L, "nome_valido", "user@mail.com", "00000000000", "password", 17, "BA", 0);	
		});
		assertEquals("Idade do Usuário não permitido para cadastramento", e.getMessage());
	}
	
	@Test
	void testBuildUsuarioComIdadeInvalidoAcimaDe65DeveRetornarError() {
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			new Usuario(1L, "nome_valido", "user@mail.com", "00000000000", "password", 66, "BA", 0);
		});
		assertEquals("Idade do Usuário não permitido para cadastramento", e.getMessage());
	}
}
