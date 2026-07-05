package view;
import dao.LivroDAO;
import model.Livro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TelaConsultaLivros extends JFrame {

    JTable tabela;
    DefaultTableModel modelo;

    public TelaConsultaLivros(){

        setTitle("Consultar Livros");
        setSize(500,300);
        setLayout(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Ano");

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20,20,440,180);
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(180,220,120,30);
        add(scroll);
        add(btnAtualizar);
        btnAtualizar.addActionListener(e -> carregarLivros());
        carregarLivros();
        setVisible(true);
    }

public void carregarLivros(){

    modelo.setRowCount(0);

    LivroDAO dao = new LivroDAO();

    ArrayList<Livro> lista = dao.listarLivros();

    for(Livro l : lista){

        modelo.addRow(new Object[]{

            l.getId(),
            l.getTitulo(),
            l.getAutor(),
            l.getAno()

        });
    }
}
}