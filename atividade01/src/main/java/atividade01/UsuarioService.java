package atividade01;

import java.util.Optional;

public class UsuarioService {

	private UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		if (!usuario.isValid()) 
			throw new IllegalStateException("Usuário não é válido para cadastro");
		this.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
			throw new RuntimeException(String.format("Usuário %s já cadastrado", user.getEmail()));
		});
		return repository.store(usuario);	
	}
	
	public Optional<Usuario> getUserByEmail(String email) {
		return repository.getUserByEmail(email);
	}
}
