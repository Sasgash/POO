package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTela {

    public JFrame frame; // Torne o frame público ou crie um getter

    public LoginTela() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panelFundo = new JPanel();
        panelFundo.setBackground(new Color(34, 40, 49));
        panelFundo.setBounds(0, 0, 350, 300);
        frame.getContentPane().add(panelFundo);
        panelFundo.setLayout(null);

        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(130, 30, 100, 30);
        panelFundo.add(lblTitulo);

        // Outras configurações...

        // Botão Entrar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEntrar.setBackground(new Color(51, 153, 255));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setBounds(100, 160, 150, 40);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibe a tela de login
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                frame.dispose();  // Fecha a tela de login
            }
        });
        panelFundo.add(btnEntrar);
    }

    // Getter para o frame
    public JFrame getFrame() {
        return frame;
    }
}