package model;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, int ano) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getId() {
    return id;
    }
    public String getAutor() {
    return autor;
    }
    public int getAno() {
    return ano;
    }
}
