package view;

import dao.UsuarioDAO;
import model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUsuario extends JFrame {

    JTextField txtNome;
    JTextField txtEmail;

    public TelaUsuario(){

        setTitle("Cadastro de Usuário");
        setSize(300,300);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        
        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        lblNome.setBounds(20,20,80,25);
        txtNome.setBounds(100,20,150,25);

        lblEmail.setBounds(20,60,80,25);
        txtEmail.setBounds(100,60,150,25);
        
        lblTelefone.setBounds(20,100,80,25);
        txtTelefone.setBounds(100,100,150,25);

        btnSalvar.setBounds(100,160,100,30);

        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefone);
        add(txtTelefone);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nome = txtNome.getText();
                String email = txtEmail.getText();

                if(nome.isEmpty() || email.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Preencha todos os campos!");
                    return;
                }
                
                String telefone = txtTelefone.getText();
                Usuario usuario = new Usuario(
                    0,
                    nome,        
                    email,
                    telefone);
                
                UsuarioDAO dao = new UsuarioDAO();
                dao.salvarUsuario(usuario);

            JOptionPane.showMessageDialog(
            null,"Usuário cadastrado com sucesso!");
                txtNome.setText("");
                txtEmail.setText("");
                txtTelefone.setText("");
            }});
        setVisible(true);
    }
}
