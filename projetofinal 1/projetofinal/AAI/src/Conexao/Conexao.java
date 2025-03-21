package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	private static String Url = "jdbc:sqlserver://10.109.8.9:1433;databaseName=POO_gp04;user=POO_gp04;" + "password=;encrypt=false;trustServerCertificate=true;loginTimeout=30;";

	public static Connection conexao; // Conecta com o banco

	public static Connection conectar() { // Efetua a conexão
		try {
			// Conexão com o banco
			conexao = DriverManager.getConnection(Url);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage());
		}
		return conexao;
	}

	public void desconectar() { // Fecha a conexão
		try {
			conexao.close(); // Fechar conexão
//			JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage());
		}
	}
}
