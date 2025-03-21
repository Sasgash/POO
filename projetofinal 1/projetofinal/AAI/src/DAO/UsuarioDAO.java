package DAO;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Dados.Usuario;

public class UsuarioDAO extends Usuario {
	
	public UsuarioDAO(String nome, String cpf, String email, String telefone, String login, String senha, float salario,
			int i, String descricao) {
		super(nome, cpf, email, telefone, login, senha, salario, i, descricao);
	}

	public void Insert(Usuario usuario) {
		Conexao con = new Conexao();
		Conexao.conectar();
		
		try {
			PreparedStatement insert =
					Conexao.conexao.prepareStatement(
							"INSERT INTO USUARIO(NOME, CPF, EMAIL, TELEFONE, LOGIN, SENHA, SALARIO, STATUS, DESCRICAO)"
							+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getCpf());
			insert.setString(3, usuario.getEmail());
			insert.setString(4, usuario.getTelefone());
			insert.setString(5, usuario.getLogin());
			insert.setString(6, usuario.getSenha());
			insert.setFloat(7, usuario.getSalario());
			insert.setString(8, String.valueOf(usuario.isStatus()));
			insert.setString(9, usuario.getDescricao());
			insert.execute();
			JOptionPane.showMessageDialog(null, "Usuário Cdastrado!");
			con.desconectar();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}
