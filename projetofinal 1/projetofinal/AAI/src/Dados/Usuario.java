 package Dados;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	private float salario;
	private char status;
	private String descricao;
	
	//Construtor
	
	public Usuario(String nome, String cpf, String email, String telefone, String login, String senha, float salario,
			int i, String descricao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.salario = salario;
		this.status = (char) i;
		this.descricao = descricao;
	}
	
	//Encapsulamento

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//toString
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", login="
				+ login + ", senha=" + senha + ", salario=" + salario + ", status=" + status + ", descricao="
				+ descricao + "]";
	}
	

	
	
	
}
