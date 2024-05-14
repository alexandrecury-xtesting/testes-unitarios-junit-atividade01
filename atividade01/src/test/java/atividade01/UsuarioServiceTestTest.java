package atividade01;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import atividade01.builders.UsuarioBuilder;
import atividade01.infra.UsuarioDummyRepository;

class UsuarioServiceTestTest {
	private UsuarioService service;

	@Test // Example with DummyRepository concrete 
	void testDeveCriarUsuarioValidoSemMockito() {
		service = new UsuarioService(new UsuarioDummyRepository());	
		Usuario usuario = UsuarioBuilder.umUsuario().addEmail("outro@mail.com").build();
		Usuario userSaved = service.criarUsuario(usuario);
		assertNotNull(userSaved);
	}
	
	@Test
	void testDeveCriarUsuarioValidoComMockito() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		Usuario usuario = UsuarioBuilder
			.umUsuario()
			.addEmail("outro@mail.com")
			.addId(null)
			.build();
		
		// Mock training
		Mockito.when(repository.getUserByEmail(usuario.getEmail()))
			.thenReturn(Optional.empty());
		Mockito.when(repository.store(usuario))
			.thenReturn(UsuarioBuilder.umUsuario().build());
		
		Usuario userSaved = service.criarUsuario(usuario);
		assertNotNull(userSaved.getId());
		
//		verify(repository, times(1)).getUserByEmail(usuario.getEmail());
//		verify(repository).store(usuario);
	}
	
	@Test
	void testDeveRetornarEmptyQuandoUsuarioComEmailInexistente() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		// Mock training
		Mockito.when(repository.getUserByEmail("outro@mail.com")).thenReturn(Optional.empty());
		
		Optional<Usuario> user = service.getUserByEmail("outro@mail.com");

		assertTrue(user.isEmpty());
	}
	
	@Test
	void testDeveRetornarUsuarioPorEmail() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		// Mock training
		Mockito.when(repository.getUserByEmail("outro@mail.com"))
			.thenReturn(Optional.of(UsuarioBuilder.umUsuario().build()));
		
		Optional<Usuario> user = service.getUserByEmail("outro@mail.com");
		assertTrue(user.isPresent());
		Mockito.verify(repository, Mockito.times(1)).getUserByEmail("outro@mail.com");
	}

}
