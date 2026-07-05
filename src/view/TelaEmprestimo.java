package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.LivroDAO;

public class TelaEmprestimo extends JFrame {

    JTextField txtLivro;
    JTextField txtUsuario;

    public TelaEmprestimo(){

        setTitle("Registrar Empréstimo");
        setSize(300,250);
        setLayout(null);

        JLabel lblLivro = new JLabel("ID Livro:");
        txtLivro = new JTextField();

        JLabel lblUsuario = new JLabel("ID Usuário:");
        txtUsuario = new JTextField();

        JButton btnRegistrar = new JButton("Registrar");

        lblLivro.setBounds(20,20,80,25);
        txtLivro.setBounds(120,20,120,25);

        lblUsuario.setBounds(20,60,80,25);
        txtUsuario.setBounds(120,60,120,25);

        btnRegistrar.setBounds(90,120,120,30);

        add(lblLivro);
        add(txtLivro);
        add(lblUsuario);
        add(txtUsuario);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String livro = txtLivro.getText();
    String usuario = txtUsuario.getText();

    if(livro.isEmpty() || usuario.isEmpty()){

        JOptionPane.showMessageDialog(
                null,
                "Preencha todos os campos!"
        );

        return;
    }

    try{

        int idLivro = Integer.parseInt(livro);

        LivroDAO dao = new LivroDAO();

        boolean sucesso =
                dao.emprestarLivro(idLivro);

        if(sucesso){

            JOptionPane.showMessageDialog(
                    null,
                    "Empréstimo registrado!"
            );

        }else{

            JOptionPane.showMessageDialog(
                    null,
                    "Livro não encontrado ou indisponível."
            );
        }

        txtLivro.setText("");
        txtUsuario.setText("");

    }catch(NumberFormatException ex){

        JOptionPane.showMessageDialog(
                null,
                "ID do livro inválido!"
        );
    }
}
        });

        setVisible(true);
    }
}