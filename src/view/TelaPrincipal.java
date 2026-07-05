package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){

        setTitle("Sistema Biblioteca");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnLivro = new JButton("Cadastrar Livro");
        JButton btnUsuario = new JButton("Cadastrar Usuário");
        JButton btnEmprestimo = new JButton("Registrar Empréstimo");

        btnLivro.setBounds(100,50,200,30);
        btnUsuario.setBounds(100,100,200,30);
        btnEmprestimo.setBounds(100,150,200,30);

        add(btnLivro);
        add(btnUsuario);
        add(btnEmprestimo);

        btnLivro.addActionListener(e -> new TelaLivro());
        btnUsuario.addActionListener(e -> new TelaUsuario());
        btnEmprestimo.addActionListener(e -> new TelaEmprestimo());

        setVisible(true);
        JButton btnConsultar = new JButton("Consultar Livros");

        btnConsultar.setBounds(100,200,200,30);

        add(btnConsultar);

        btnConsultar.addActionListener(e -> new TelaConsultaLivros());
    }
}
