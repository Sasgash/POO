package Dados;

public class Busca {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private float salario;
	private char status;
	private String descricao;
	private int id_cargo;
	
	
	// Construtor
	
	public Busca(String nome, String cpf, String email, String telefone, float salario, float salario_base, int id_cargo,
			int i, String descricao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.salario = salario;
		this.id_cargo = id_cargo;
		this.status = (char) i;
		this.descricao = descricao;
	}


	// Encapsulamento
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getCargo() {
		return id_cargo;
	}
	
	public void setCargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public char isStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	public String getStatusTexto() {
	    if (status == 'A') {
	        return "Ativo";
	    } else if (status == 'I') {
	        return "Inativo";
	    } else {
	        return "Desconhecido";  // Caso o status não seja A ou I
	    }
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return "Busca [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", "
				+ "salario=" + salario + ", status=" + status + ", descricao=" + descricao + 
				", id_cargo=" + id_cargo + "]";
	}
	
	
	
}
