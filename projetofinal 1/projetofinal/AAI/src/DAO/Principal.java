package DAO;

public class Principal {

	public static void main(String[] args) {
	
		UsuarioDAO teste =
			new UsuarioDAO("Amanda", "cpf", "email", "telefone", "login", "senha", 25.96f, 'A', "descricao");
		teste.Insert(teste);
	 
	}

}
