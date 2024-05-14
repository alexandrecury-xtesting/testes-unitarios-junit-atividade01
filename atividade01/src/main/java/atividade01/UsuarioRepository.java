package atividade01;

import java.util.Optional;

public interface UsuarioRepository {
	
	Usuario store(Usuario usuario);
	
	Optional<Usuario> getUserByEmail(String email);
}
