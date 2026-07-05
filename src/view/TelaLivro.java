package view;

import dao.LivroDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Livro;

public class TelaLivro extends JFrame {

    JTextField txtTitulo;
    JTextField txtAutor;

    public TelaLivro(){

        setTitle("Cadastro de Livro");
        setSize(300,250);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        txtTitulo = new JTextField();

        JLabel lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        lblTitulo.setBounds(20,20,80,25);
        txtTitulo.setBounds(100,20,150,25);

        lblAutor.setBounds(20,60,80,25);
        txtAutor.setBounds(100,60,150,25);

        btnSalvar.setBounds(100,120,100,30);

        add(lblTitulo);
        add(txtTitulo);
        add(lblAutor);
        add(txtAutor);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();

        if(titulo.isEmpty() || autor.isEmpty()){

            JOptionPane.showMessageDialog(null,
                    "Preencha todos os campos!");

            return;
        }

        LivroDAO dao = new LivroDAO();

        Livro livro = new Livro(
        0, titulo, autor, 2025);

        dao.salvarLivro(livro);
        
    JOptionPane.showMessageDialog(null,
    "Livro cadastrado com sucesso!");

        txtTitulo.setText("");
        txtAutor.setText("");
    }
});
        setVisible(true);
    }
}