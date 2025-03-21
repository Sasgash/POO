package Telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import DAO.CargoDAO;
import DAO.UsuarioDAO;
import Dados.Cargo;

import java.awt.Font;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Label;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargoTela {

    private JFrame Cargo;
    private JTextField textNomeCargo;
    private JFormattedTextField textSalarioBase;  // Alterado para JFormattedTextField
    private JTextField textDescricao;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CargoTela window = new CargoTela();
                window.Cargo.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CargoTela() {
        initialize();
    }

    private void initialize() {
        Cargo = new JFrame();
        Cargo.setTitle("Cargo");
        Cargo.setBounds(100, 100, 500, 300);
        Cargo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cargo.getContentPane().setLayout(null);

        Label label = new Label("Cargo:");
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setBounds(10, 41, 51, 14);
        Cargo.getContentPane().add(label);

        Label label_2 = new Label("Salário Base:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_2.setBounds(10, 69, 78, 14);
        Cargo.getContentPane().add(label_2);

        // Criando a máscara de formato para o salário
        MaskFormatter maskFormatter = new MaskFormatter();
        try {
            maskFormatter.setMask("R$ ##,###,##0.00");  // Máscara de moeda
            maskFormatter.setPlaceholderCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }

        Label label_2_2 = new Label("Descrição:");
        label_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_2_2.setBounds(10, 102, 78, 14);
        Cargo.getContentPane().add(label_2_2);
        
        textNomeCargo = new JTextField();
        textNomeCargo.setBounds(114, 35, 360, 20);
        Cargo.getContentPane().add(textNomeCargo);
        textNomeCargo.setColumns(10);
        
        // Substituindo o JTextField por JFormattedTextField
        textSalarioBase = new JFormattedTextField(maskFormatter);
        textSalarioBase.setBounds(114, 63, 360, 20);
        Cargo.getContentPane().add(textSalarioBase);
        textSalarioBase.setColumns(10);
        
        textDescricao = new JTextField();
        textDescricao.setBounds(10, 122, 464, 91);
        Cargo.getContentPane().add(textDescricao);
        textDescricao.setColumns(10);
        
        JButton btnCadastrarCargo = new JButton("Cadastrar");
        btnCadastrarCargo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				// Usando o valor do texto para o salário base como número
				String salarioText = textSalarioBase.getText().replace("R$", "").replace(",", "").replace(".", "");
				Float salario = Float.parseFloat(salarioText) / 100; // Convertendo para valor monetário correto
				CargoDAO teste = new CargoDAO(textNomeCargo.getText(), salario, textDescricao.getText());
				teste.Insert(teste);
        	}
        });
        btnCadastrarCargo.setBounds(174, 224, 116, 23);
        Cargo.getContentPane().add(btnCadastrarCargo);
    }
}
