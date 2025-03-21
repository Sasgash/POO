package DAO;

import java.sql.*;
import javax.swing.JOptionPane;
import Conexao.Conexao;
import Dados.Busca;

public class BuscaTelaDAO extends Busca {

    // Construtor da classe BuscaTelaDAO, herdando da classe Busca
    public BuscaTelaDAO(String nome, String cpf, String email, String telefone, float salario, float salario_base,
                        int id_cargo, int i, String descricao) {
        super(nome, cpf, email, telefone, salario, salario_base, id_cargo, i, descricao);
    }

    // Método para selecionar um usuário no banco de dados com base no CPF
    public void Select() {
        // Conectar ao banco de dados (estático)
        try (Connection con = Conexao.conectar()) { // Usando try-with-resources para garantir fechamento da conexão
            String sql = "SELECT * FROM USUARIO WHERE cpf = ?";

            // Preparando a instrução SQL para execução
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, getCpf()); // Usa o CPF da instância da classe BuscaTelaDAO

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // Preencher os campos da classe Busca com os dados do banco
                        setNome(rs.getString("nome"));
                        setCpf(rs.getString("cpf"));
                        setTelefone(rs.getString("telefone"));
                        setEmail(rs.getString("email"));
                        setSalario(rs.getFloat("salario"));
                        setStatus(rs.getString("status").charAt(0));
                        setDescricao(rs.getString("descricao"));
                        setCargo(rs.getInt("id_cargo"));
                        
                        // Exibir mensagem de sucesso
                        JOptionPane.showMessageDialog(null, "Registro encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o CPF informado.");
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na consulta: " + e.getMessage());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados: " + e.getMessage());
        }
    }
}
