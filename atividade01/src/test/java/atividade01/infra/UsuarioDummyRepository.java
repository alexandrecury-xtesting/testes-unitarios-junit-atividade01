package atividade01.infra;

import java.util.Optional;

import atividade01.Usuario;
import atividade01.UsuarioRepository;
import atividade01.builders.UsuarioBuilder;

public class UsuarioDummyRepository implements UsuarioRepository{

	@Override
	public Usuario store(Usuario usuario) {
		return UsuarioBuilder.umUsuario()
				.addName(usuario.getName())
				.addAge(usuario.getAge())
				.build();
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		if ("user@mail.com".equals(email))
			return Optional.of(UsuarioBuilder
				.umUsuario()
				.addEmail(email)
				.build()
			);
		return Optional.empty();
	}

}
