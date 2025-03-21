package Dados;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Canvas;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param senha 
	 * @param loginUsuario 
	 */
	public Login(String loginUsuario, String senha) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label lblLogin = new Label("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(10, 82, 62, 22);
		frame.getContentPane().add(lblLogin);
		
		TextField txtLogin = new TextField();
		txtLogin.setBounds(78, 82, 149, 22);
		frame.getContentPane().add(txtLogin);
		
		Label lblSenha = new Label("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(10, 117, 62, 22);
		frame.getContentPane().add(lblSenha);
		
		TextField textSenha = new TextField();
		textSenha.setBounds(78, 117, 149, 22);
		frame.getContentPane().add(textSenha);
		
		Label lblTitulo = new Label("Tela de Login");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setAlignment(Label.CENTER);
		lblTitulo.setBounds(140, 10, 130, 32);
		frame.getContentPane().add(lblTitulo);
		
		Button btnEntrar = new Button("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(225, 197, 70, 22);
		frame.getContentPane().add(btnEntrar);
		
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(120, 197, 70, 22);
		frame.getContentPane().add(btnCadastrar);
	}
}
