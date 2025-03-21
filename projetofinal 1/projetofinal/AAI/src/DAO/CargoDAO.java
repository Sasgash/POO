package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Dados.Cargo;

public class CargoDAO extends Cargo {

	public CargoDAO(String nome, double salarioBase, String descricao) {
		super(nome, salarioBase, descricao);
	}
	
	

	public CargoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void Insert(Cargo cargo) {
		Conexao con = new Conexao();
		Conexao.conectar();

		try {
			PreparedStatement insert = Conexao.conexao
					.prepareStatement("INSERT INTO CARGO(NOME_CARGO, SALARIO_BASE, DESCRICAO)" + "VALUES(?, ?, ?)");
			insert.setString(1, cargo.getNome());
			insert.setFloat(2, (float) cargo.getSalarioBase());
			insert.setString(3, cargo.getDescricao());
			insert.execute();
			JOptionPane.showMessageDialog(null, "Usuário Cdastrado!");
			con.desconectar();

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<String> getCargos() {
		List<String> cargos = new ArrayList<>();
		String sql = "SELECT nome_cargo FROM CARGO"; // Supondo que existe uma tabela "cargos" no banco
		Conexao con = new Conexao();

		try {
			Conexao.conectar();
			Statement stmt = Conexao.conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cargos.add(rs.getString("nome_cargo")); // Adiciona o cargo à lista
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.desconectar();
		}

		return cargos;
	}

}