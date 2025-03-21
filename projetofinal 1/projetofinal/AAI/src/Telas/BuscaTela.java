package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import DAO.BuscaTelaDAO;
import Dados.Busca;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BuscaTela {

    private JFrame Usuario;
    private JLabel lblNome;
    private JLabel lblSalario;
    private JLabel lblTelefone;
    private JLabel lblEmail;
    private JLabel lblDescricao;
    private JTextField txt_nome;
    private JTextField txt_cpf;
    private JTextField txt_telefone;
    private JTextField txt_email;
    private JTextField txt_salario;
    private JTextField txt_descricao;
    private JTextField txt_busca;
    private JTextField txt_Cargo;
    private JTextField txtStatus;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuscaTela window = new BuscaTela();
                    window.Usuario.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuscaTela() {
        initialize();
    }

    private void initialize() {
        Usuario = new JFrame("Cadastro de Usuário");
        Usuario.setBounds(100, 100, 384, 349);
        Usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Usuario.getContentPane().setLayout(null);

        JButton btnBuscar = new JButton("Gerar Relatório");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = txt_busca.getText();
                if (cpf != null && !cpf.isEmpty()) {
                    // Cria uma instância de BuscaTelaDAO com o CPF fornecido
                    BuscaTelaDAO buscaTelaDAO = new BuscaTelaDAO("", cpf, "", "", 0, 0, 0, 0, "");
                    buscaTelaDAO.Select(); // Chama o método Select para realizar a consulta

                    // Verifica se a consulta foi bem-sucedida e preenche os campos
                    if (buscaTelaDAO.getNome() != null && !buscaTelaDAO.getNome().isEmpty()) {
                        txt_nome.setText(buscaTelaDAO.getNome());
                        txt_cpf.setText(buscaTelaDAO.getCpf());
                        txt_telefone.setText(buscaTelaDAO.getTelefone());
                        txt_email.setText(buscaTelaDAO.getEmail());
                        txt_salario.setText(String.valueOf(buscaTelaDAO.getSalario()));
                        txtStatus.setText(buscaTelaDAO.getStatusTexto());
                        txt_descricao.setText(buscaTelaDAO.getDescricao());
             
         
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o CPF informado.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um CPF.");
                }
            }
        });
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBuscar.setBounds(21, 59, 333, 36);
        Usuario.getContentPane().add(btnBuscar);

        JLabel lbl_buscacpf = new JLabel("Buscar por CPF:");
        lbl_buscacpf.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl_buscacpf.setBounds(10, 21, 109, 14);
        Usuario.getContentPane().add(lbl_buscacpf);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 118, 46, 14);
        Usuario.getContentPane().add(lblNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(10, 143, 46, 14);
        Usuario.getContentPane().add(lblCpf);

        lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(10, 214, 46, 14);
        Usuario.getContentPane().add(lblSalario);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 168, 46, 14);
        Usuario.getContentPane().add(lblTelefone);

        lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(10, 193, 46, 14);
        Usuario.getContentPane().add(lblEmail);

        lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(10, 264, 62, 14);
        Usuario.getContentPane().add(lblDescricao);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(10, 239, 46, 14);
        Usuario.getContentPane().add(lblStatus);

        txt_nome = new JTextField();
        txt_nome.setBounds(88, 115, 266, 20);
        Usuario.getContentPane().add(txt_nome);
        txt_nome.setColumns(10);

        txt_cpf = new JFormattedTextField(setMascara("###.###.###-##"));
        txt_cpf.setBounds(88, 140, 266, 20);
        Usuario.getContentPane().add(txt_cpf);
        txt_cpf.setColumns(10);

        txt_telefone = new JFormattedTextField(setMascara("(##) #####-####"));
        txt_telefone.setBounds(88, 165, 266, 20);
        Usuario.getContentPane().add(txt_telefone);
        txt_telefone.setColumns(10);

        txt_email = new JTextField();
        txt_email.setBounds(88, 190, 266, 20);
        Usuario.getContentPane().add(txt_email);
        txt_email.setColumns(10);

        txt_salario = new JTextField();
        txt_salario.setBounds(88, 211, 266, 20);
        Usuario.getContentPane().add(txt_salario);
        txt_salario.setColumns(10);

        txt_descricao = new JTextField();
        txt_descricao.setBounds(88, 261, 266, 20);
        Usuario.getContentPane().add(txt_descricao);
        txt_descricao.setColumns(10);

        txt_busca = new JTextField();
        txt_busca.setBounds(152, 19, 202, 20);
        Usuario.getContentPane().add(txt_busca);
        txt_busca.setColumns(10);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(10, 289, 46, 14);
        Usuario.getContentPane().add(lblCargo);

        txt_Cargo = new JTextField();
        txt_Cargo.setBounds(88, 286, 266, 20);
        Usuario.getContentPane().add(txt_Cargo);
        txt_Cargo.setColumns(10);
        
        txtStatus = new JTextField();
        txtStatus.setBounds(88, 236, 266, 20);
        Usuario.getContentPane().add(txtStatus);
        txtStatus.setColumns(10);
    }

    private MaskFormatter setMascara(final String mascara) {
        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(mascara);
            F_Mascara.setPlaceholderCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }
        return F_Mascara;
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
