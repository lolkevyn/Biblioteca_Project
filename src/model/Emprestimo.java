package model;

import dao.LivroDAO;
import java.util.Date;

public class Emprestimo {

    private int id;
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;

    public Emprestimo(int id, Livro livro, Usuario usuario) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = new Date();
    }

    public void registrar() {

    if(livro.isDisponivel()){
        livro.setDisponivel(false);
        LivroDAO dao = new LivroDAO();
        dao.atualizarDisponibilidade(
            livro.getId(),
            false
        );
        System.out.println(
            "Empréstimo realizado com sucesso!"
        );
        
    }else{
        System.out.println("Livro indisponível.");
        }
    }
}