package DAO;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Dados.Login;
import Dados.Usuario;

public class LoginDAO extends Login {
	
	public LoginDAO(String loginUsuario, String senha) {
		super(loginUsuario, senha);}
		public void Insert(Usuario usuario) {
			Conexao con = new Conexao();
			Conexao.conectar();
			
			try {
				PreparedStatement insert =
						Conexao.conexao.prepareStatement(
								"INSERT INTO USUARIO(LOGIN_USUARIO)"
								+ "VALUES(?, ?)");
				insert.setString(1, usuario.getNome());
				insert.setString(2, usuario.getCpf());
				
				insert.execute();
				JOptionPane.showMessageDialog(null, "!");
				con.desconectar();
			}

			catch (Exception e) {
				System.out.println(e);
			}

		}

}
