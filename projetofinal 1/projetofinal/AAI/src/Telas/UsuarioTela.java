package Telas;

import java.awt.Button;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import DAO.CargoDAO;
import DAO.UsuarioDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class UsuarioTela {

	private JFrame Usuario;
	private JTextField txt_nome;
	private JTextField txt_email;
	private JTextField txt_login;
	private JTextField txt_senha;
	private JTextField txt_descricao;
	private JFormattedTextField txt_cpf;
	private JFormattedTextField txt_telefone;
	private JFormattedTextField txt_salario;
	private JComboBox<String> comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioTela window = new UsuarioTela();
					window.Usuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UsuarioTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Usuario = new JFrame("Cadastro de Usuário");
		Usuario.setBounds(100, 100, 384, 515);
		Usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Usuario.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(21, 22, 46, 14);
		Usuario.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(21, 53, 46, 14);
		Usuario.getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(21, 135, 46, 14);
		Usuario.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(21, 91, 62, 14);
		Usuario.getContentPane().add(lblTelefone);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin.setBounds(21, 180, 46, 14);
		Usuario.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(21, 214, 46, 14);
		Usuario.getContentPane().add(lblSenha);
		
		JLabel lblSalario = new JLabel("Salário:");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalario.setBounds(21, 252, 46, 14);
		Usuario.getContentPane().add(lblSalario);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescricao.setBounds(21, 345, 76, 14);
		Usuario.getContentPane().add(lblDescricao);
		
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String cpf = txt_cpf.getText().replace(".", "");
					cpf = cpf.replace("-", "");
					
					String telefone = txt_telefone.getText().replace("(", "");
					telefone = telefone.replace(")", "");
					telefone = telefone.replace("-", "");
					telefone = telefone.replace(" ", "");
					
					UsuarioDAO teste =
						new UsuarioDAO(txt_nome.getText(), cpf, txt_email.getText(), telefone, txt_login.getText(), txt_senha.getText(), Float.parseFloat(txt_salario.getText()),'A', txt_descricao.getText());
					teste.Insert(teste);
				 
				}
			}
		);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setBounds(21, 419, 333, 36);
		Usuario.getContentPane().add(btnCadastrar);
		
		txt_cpf = new JFormattedTextField(setMascara("###.###.###-##"));
		txt_cpf.setBounds(83, 52, 271, 18);
		Usuario.getContentPane().add(txt_cpf);
		
		txt_telefone = new JFormattedTextField(setMascara("(##) #####-####"));
		txt_telefone.setBounds(83, 90, 271, 18);
		Usuario.getContentPane().add(txt_telefone);
		
		txt_salario = new JFormattedTextField();
		txt_salario.setBounds(83, 251, 271, 18);
		Usuario.getContentPane().add(txt_salario);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(83, 21, 271, 17);
		Usuario.getContentPane().add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(83, 133, 271, 17);
		Usuario.getContentPane().add(txt_email);
		
		txt_login = new JTextField();
		txt_login.setColumns(10);
		txt_login.setBounds(83, 179, 271, 17);
		Usuario.getContentPane().add(txt_login);
		
		txt_senha = new JTextField();
		txt_senha.setColumns(10);
		txt_senha.setBounds(83, 213, 271, 17);
		Usuario.getContentPane().add(txt_senha);
		
		txt_descricao = new JTextField();
		txt_descricao.setBounds(21, 370, 333, 43);
		Usuario.getContentPane().add(txt_descricao);
		txt_descricao.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCargo.setBounds(21, 301, 46, 14);
		Usuario.getContentPane().add(lblCargo);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(83, 298, 271, 22);
		Usuario.getContentPane().add(comboBox);
		carregarCargo();
		
		
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
	
	
	private void carregarCargo() {
		CargoDAO cargoDAO = new CargoDAO();
		List<String> cargos = cargoDAO.getCargos();  // Suponha que esse método retorna uma lista de cargos
		for (String cargo : cargos) {
		    comboBox.addItem(cargo);  // Adiciona cada cargo ao JComboBox
		}

	}
}


