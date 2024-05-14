package atividade01;

public class Usuario {
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private String password;
	private int age;
	private String uf;
	private long current_agency_id;

	public Usuario(
			Long id, 
			String name,
			String email,
			String cpf,
			String password,
			int age,
			String uf,
			long current_agency_id
	) {
		if (age < 18 || age > 65) {
			throw new RuntimeException("Idade do Usuário não permitido para cadastramento");
		}
		if (name == null) throw new RuntimeException("Nome é obrigatório");
		if (email == null) throw new RuntimeException("Email é obrigatório");
		if (cpf == null) throw new RuntimeException("CPF é obrigatório");
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.age = age;
		this.uf = uf;
		this.current_agency_id = current_agency_id;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getPassword() {
		return password;
	}

	public String getUf() {
		return uf;
	}

	public Long getCurrent_agency_id() {
		return current_agency_id;
	}

	public boolean isValid() {
		return this.getAge() >= 18 && this.getAge() <= 65;
	}
	
}
